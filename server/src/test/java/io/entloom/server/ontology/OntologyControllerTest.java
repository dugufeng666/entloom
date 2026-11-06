package io.entloom.server.ontology;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

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
class OntologyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProjectRepository projectRepository;

    @Test
    @WithMockUser
    void createsAndListsOntologyWithinProject() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Customer model", null));

        mockMvc.perform(post("/api/v1/projects/{projectId}/ontologies", project.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Customer ontology\",\"description\":\"Core entities\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.projectId").value(project.getId().toString()))
                .andExpect(jsonPath("$.name").value("Customer ontology"))
                .andExpect(jsonPath("$.status").value("DRAFT"));

        mockMvc.perform(get("/api/v1/projects/{projectId}/ontologies", project.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Customer ontology"));
    }

    @Test
    @WithMockUser
    void supportsOntologyDetailsAndReleaseLifecycle() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Agent model", null));
        Ontology ontology = ontologyRepository.saveAndFlush(Ontology.create(
                project.getId(), "Agent ontology", "Initial"));

        mockMvc.perform(get("/api/v1/projects/{projectId}/ontologies/{id}", project.getId(), ontology.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("DRAFT"));

        mockMvc.perform(patch("/api/v1/projects/{projectId}/ontologies/{id}", project.getId(), ontology.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Agent context ontology\",\"description\":\"Updated\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Agent context ontology"));

        mockMvc.perform(patch("/api/v1/projects/{projectId}/ontologies/{id}/status", project.getId(), ontology.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"status\":\"RELEASED\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("RELEASED"));
    }

    @Test
    @WithMockUser
    void rejectsInvalidOntologyLifecycleTransition() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Archive model", null));
        Ontology ontology = ontologyRepository.saveAndFlush(Ontology.create(
                project.getId(), "Archive ontology", null));

        mockMvc.perform(patch("/api/v1/projects/{projectId}/ontologies/{id}/status", project.getId(), ontology.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"status\":\"ARCHIVED\"}"))
                .andExpect(status().isOk());

        mockMvc.perform(patch("/api/v1/projects/{projectId}/ontologies/{id}/status", project.getId(), ontology.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"status\":\"DRAFT\"}"))
                .andExpect(status().isConflict());
    }

    @Test
    @WithMockUser
    void returnsNotFoundForUnknownProject() throws Exception {
        mockMvc.perform(get("/api/v1/projects/{projectId}/ontologies", UUID.randomUUID()))
                .andExpect(status().isNotFound());
    }

    @Autowired
    private OntologyRepository ontologyRepository;
}
