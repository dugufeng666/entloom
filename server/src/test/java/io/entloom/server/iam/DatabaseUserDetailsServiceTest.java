package io.entloom.server.iam;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

class DatabaseUserDetailsServiceTest {

    private final UserAccountRepository repository = mock(UserAccountRepository.class);
    private final DatabaseUserDetailsService service = new DatabaseUserDetailsService(repository);

    @Test
    void mapsDatabaseUserToSpringSecurityUser() {
        UserAccount account = UserAccount.create(
                "architect",
                "{bcrypt}$2a$10$hash",
                "Enterprise architect",
                Set.of("ROLE_ADMIN", "ROLE_STEWARD"));
        when(repository.findByUsernameIgnoreCase("architect")).thenReturn(Optional.of(account));

        var user = service.loadUserByUsername("architect");

        assertThat(user.getUsername()).isEqualTo("architect");
        assertThat(user.getPassword()).isEqualTo("{bcrypt}$2a$10$hash");
        assertThat(user.getAuthorities()).extracting("authority")
                .containsExactlyInAnyOrder("ROLE_ADMIN", "ROLE_STEWARD");
    }

    @Test
    void rejectsUnknownUser() {
        when(repository.findByUsernameIgnoreCase("missing")).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.loadUserByUsername("missing"))
                .isInstanceOf(UsernameNotFoundException.class);
    }
}
