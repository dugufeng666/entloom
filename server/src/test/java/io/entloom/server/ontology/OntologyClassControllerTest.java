package io.entloom.server.ontology;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import io.entloom.server.project.Project;
import io.entloom.server.project.ProjectRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class OntologyClassControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    OntologyRepository ontologyRepository;

    @Test
    @WithMockUser
    void createsAndListsClassesInDraftOntology() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Customer model", null));
        Ontology ontology = ontologyRepository.saveAndFlush(Ontology.create(project.getId(), "Customer ontology", null));

        mockMvc.perform(post("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes", project.getId(), ontology.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Customer\",\"description\":\"A business customer\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.ontologyId").value(ontology.getId().toString()))
                .andExpect(jsonPath("$.name").value("Customer"));

        mockMvc.perform(get("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes", project.getId(), ontology.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    @WithMockUser
    void blocksClassChangesAfterOntologyRelease() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Agent model", null));
        Ontology ontology = ontologyRepository.saveAndFlush(Ontology.create(project.getId(), "Agent ontology", null));
        ontology.changeStatus(OntologyStatus.RELEASED);
        ontologyRepository.saveAndFlush(ontology);

        mockMvc.perform(post("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes", project.getId(), ontology.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Agent\"}"))
                .andExpect(status().isConflict());
    }

    @Test
    @WithMockUser
    void updatesClassDetailsWhileOntologyIsDraft() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Order model", null));
        Ontology ontology = ontologyRepository.saveAndFlush(Ontology.create(project.getId(), "Order ontology", null));
        OntologyClass ontologyClass = ontologyClassRepository.saveAndFlush(
                OntologyClass.create(ontology.getId(), "Order", null));

        mockMvc.perform(patch("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{id}",
                        project.getId(), ontology.getId(), ontologyClass.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Purchase order\",\"description\":\"Updated\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Purchase order"));
    }

    @Autowired
    private OntologyClassRepository ontologyClassRepository;
}
