package io.entloom.server.ontology;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
class OntologyReleaseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    OntologyRepository ontologyRepository;

    @Autowired
    OntologyClassRepository ontologyClassRepository;

    @Test
    @WithMockUser(username = "release-manager")
    void createsAndListsSemanticReleaseManifest() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Customer model", null));
        Ontology ontology = ontologyRepository.saveAndFlush(Ontology.create(project.getId(), "Customer ontology", null));
        ontologyClassRepository.saveAndFlush(OntologyClass.create(ontology.getId(), "Customer", null));

        mockMvc.perform(post("/api/v1/projects/{projectId}/ontologies/{ontologyId}/releases", project.getId(), ontology.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"version\":\"1.0.0\",\"notes\":\"Initial customer model\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.version").value("1.0.0"))
                .andExpect(jsonPath("$.releasedBy").value("release-manager"))
                .andExpect(jsonPath("$.classCount").value(1))
                .andExpect(jsonPath("$.propertyCount").value(0))
                .andExpect(jsonPath("$.relationCount").value(0));

        mockMvc.perform(get("/api/v1/projects/{projectId}/ontologies/{ontologyId}/releases", project.getId(), ontology.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].version").value("1.0.0"));
    }

    @Test
    @WithMockUser
    void rejectsSecondReleaseWhileOntologyIsReleased() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Agent model", null));
        Ontology ontology = ontologyRepository.saveAndFlush(Ontology.create(project.getId(), "Agent ontology", null));

        mockMvc.perform(post("/api/v1/projects/{projectId}/ontologies/{ontologyId}/releases", project.getId(), ontology.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"version\":\"1.0.0\"}"))
                .andExpect(status().isCreated());

        mockMvc.perform(post("/api/v1/projects/{projectId}/ontologies/{ontologyId}/releases", project.getId(), ontology.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"version\":\"1.1.0\"}"))
                .andExpect(status().isConflict());
    }

    @Test
    @WithMockUser
    void validatesSemanticVersionFormat() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Invalid model", null));
        Ontology ontology = ontologyRepository.saveAndFlush(Ontology.create(project.getId(), "Invalid ontology", null));

        mockMvc.perform(post("/api/v1/projects/{projectId}/ontologies/{ontologyId}/releases", project.getId(), ontology.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"version\":\"v1\"}"))
                .andExpect(status().isBadRequest());
    }
}
