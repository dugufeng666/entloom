package io.entloom.server.auth;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import io.entloom.server.iam.UserAccount;
import io.entloom.server.iam.UserAccountRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AuthControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    @WithMockUser(username = "architect", roles = "ADMIN")
    void returnsCurrentUser() throws Exception {
        mockMvc.perform(get("/api/v1/auth/me"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("architect"))
                .andExpect(jsonPath("$.roles[0]").value("ROLE_ADMIN"));
    }

    @Test
    void rejectsAnonymousRequests() throws Exception {
        mockMvc.perform(get("/api/v1/auth/me"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void authenticatesAgainstDatabaseUser() throws Exception {
        userAccountRepository.save(UserAccount.create(
                "database-user",
                passwordEncoder.encode("secret"),
                "Database user",
                Set.of("ROLE_ADMIN")));

        mockMvc.perform(get("/api/v1/auth/me")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("database-user", "secret")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("database-user"))
                .andExpect(jsonPath("$.roles[0]").value("ROLE_ADMIN"));
    }
}
