package io.entloom.server.project;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ProjectControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProjectRepository projectRepository;

    @Test
    @WithMockUser
    void createsProjectAndReturnsItsIdentity() throws Exception {
        mockMvc.perform(post("/api/v1/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Library model\",\"description\":\"A teaching project\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Library model"))
                .andExpect(jsonPath("$.description").value("A teaching project"))
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    @WithMockUser
    void listsProjectsInUpdatedOrder() throws Exception {
        mockMvc.perform(post("/api/v1/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"First\",\"description\":\"Older\"}"));
        mockMvc.perform(post("/api/v1/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Second\",\"description\":\"Newer\"}"));

        mockMvc.perform(get("/api/v1/projects"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Second"))
                .andExpect(jsonPath("$[1].name").value("First"));
    }

    @Test
    @WithMockUser
    void readsAndUpdatesProjectDetails() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Draft", "Initial description"));

        mockMvc.perform(get("/api/v1/projects/{id}", project.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Draft"))
                .andExpect(jsonPath("$.status").value("DRAFT"));

        mockMvc.perform(patch("/api/v1/projects/{id}", project.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Customer ontology\",\"description\":\"Updated description\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Customer ontology"))
                .andExpect(jsonPath("$.description").value("Updated description"));
    }

    @Test
    @WithMockUser
    void enforcesForwardOnlyProjectLifecycle() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Lifecycle", null));

        mockMvc.perform(patch("/api/v1/projects/{id}/status", project.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"status\":\"ACTIVE\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ACTIVE"));

        mockMvc.perform(patch("/api/v1/projects/{id}/status", project.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"status\":\"ARCHIVED\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ARCHIVED"));

        mockMvc.perform(patch("/api/v1/projects/{id}/status", project.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"status\":\"DRAFT\"}"))
                .andExpect(status().isConflict());
    }

    @Test
    @WithMockUser
    void returnsNotFoundForUnknownProject() throws Exception {
        mockMvc.perform(get("/api/v1/projects/{id}", "00000000-0000-0000-0000-000000000001"))
                .andExpect(status().isNotFound());
    }
}
