package io.entloom.server.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class OpenApiContractTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser
    void servesGeneratedYamlContract() throws Exception {
        mockMvc.perform(get("/api/v1/openapi.yaml"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("openapi:")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("/api/v1/projects")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("CreateProjectRequest")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("ProjectResponse")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("OntologyTransferRequest")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("OntologyValidationJobResponse")));
    }

    @Test
    void checkedInContractSnapshotContainsTypedSchemas() throws Exception {
        try (InputStream input = getClass().getResourceAsStream("/openapi/entloom.yaml")) {
            org.junit.jupiter.api.Assertions.assertNotNull(input);
            String snapshot = new String(input.readAllBytes(), StandardCharsets.UTF_8);
            org.junit.jupiter.api.Assertions.assertTrue(snapshot.contains("CreateProjectRequest"));
            org.junit.jupiter.api.Assertions.assertTrue(snapshot.contains("ProjectResponse"));
            org.junit.jupiter.api.Assertions.assertTrue(snapshot.contains("OntologyTransferRequest"));
            org.junit.jupiter.api.Assertions.assertTrue(snapshot.contains("OntologyValidationJobResponse"));
        }
    }
}
