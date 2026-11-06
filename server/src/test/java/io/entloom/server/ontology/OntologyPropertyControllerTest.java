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
class OntologyPropertyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    OntologyRepository ontologyRepository;

    @Autowired
    OntologyClassRepository ontologyClassRepository;

    @Autowired
    OntologyPropertyRepository ontologyPropertyRepository;

    @Test
    @WithMockUser
    void createsAndListsPropertiesForOntologyClass() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Customer model", null));
        Ontology ontology = ontologyRepository.saveAndFlush(Ontology.create(project.getId(), "Customer ontology", null));
        OntologyClass ontologyClass = ontologyClassRepository.saveAndFlush(
                OntologyClass.create(ontology.getId(), "Customer", null));

        mockMvc.perform(post("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties",
                        project.getId(), ontology.getId(), ontologyClass.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"email\",\"description\":\"Primary email\",\"valueType\":\"TEXT\",\"required\":true}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.classId").value(ontologyClass.getId().toString()))
                .andExpect(jsonPath("$.name").value("email"))
                .andExpect(jsonPath("$.valueType").value("TEXT"))
                .andExpect(jsonPath("$.required").value(true));

        mockMvc.perform(get("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties",
                        project.getId(), ontology.getId(), ontologyClass.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    @WithMockUser
    void updatesPropertyWhileOntologyIsDraft() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Order model", null));
        Ontology ontology = ontologyRepository.saveAndFlush(Ontology.create(project.getId(), "Order ontology", null));
        OntologyClass ontologyClass = ontologyClassRepository.saveAndFlush(
                OntologyClass.create(ontology.getId(), "Order", null));
        OntologyProperty property = ontologyPropertyRepository.saveAndFlush(OntologyProperty.create(
                ontology.getId(), ontologyClass.getId(), "total", "Order total", OntologyPropertyValueType.NUMBER, true));

        mockMvc.perform(patch("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties/{id}",
                        project.getId(), ontology.getId(), ontologyClass.getId(), property.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"totalAmount\",\"description\":\"Gross total\",\"valueType\":\"NUMBER\",\"required\":false}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("totalAmount"))
                .andExpect(jsonPath("$.required").value(false));
    }

    @Test
    @WithMockUser
    void blocksPropertyChangesAfterOntologyRelease() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Agent model", null));
        Ontology ontology = ontologyRepository.saveAndFlush(Ontology.create(project.getId(), "Agent ontology", null));
        OntologyClass ontologyClass = ontologyClassRepository.saveAndFlush(
                OntologyClass.create(ontology.getId(), "Agent", null));
        ontology.changeStatus(OntologyStatus.RELEASED);
        ontologyRepository.saveAndFlush(ontology);

        mockMvc.perform(post("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties",
                        project.getId(), ontology.getId(), ontologyClass.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"name\",\"valueType\":\"TEXT\",\"required\":true}"))
                .andExpect(status().isConflict());
    }
}
