package io.entloom.server.iam;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

class DevUserInitializerTest {

    private final UserAccountRepository repository = mock(UserAccountRepository.class);
    private final PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);

    @Test
    void seedsDeveloperAdminWhenMissing() {
        when(repository.findByUsernameIgnoreCase("entloom")).thenReturn(Optional.empty());
        when(passwordEncoder.encode("secret")).thenReturn("encoded-secret");

        new DevUserInitializer(repository, passwordEncoder, "entloom", "secret").run();

        var account = org.mockito.ArgumentCaptor.forClass(UserAccount.class);
        verify(repository).save(account.capture());
        assertThat(account.getValue().getUsername()).isEqualTo("entloom");
        assertThat(account.getValue().getPasswordHash()).isEqualTo("encoded-secret");
        assertThat(account.getValue().getRoles()).containsExactly("ROLE_ADMIN");
    }

    @Test
    void doesNotOverwriteExistingDeveloperUser() {
        when(repository.findByUsernameIgnoreCase("entloom"))
                .thenReturn(Optional.of(UserAccount.create("entloom", "existing", "Existing", java.util.Set.of("ROLE_ADMIN"))));

        new DevUserInitializer(repository, passwordEncoder, "entloom", "secret").run();

        verifyNoInteractions(passwordEncoder);
        org.mockito.Mockito.verify(repository, org.mockito.Mockito.never()).save(any(UserAccount.class));
    }
}
