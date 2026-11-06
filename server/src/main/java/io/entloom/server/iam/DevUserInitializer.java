package io.entloom.server.iam;

import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class DevUserInitializer implements CommandLineRunner {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final String username;
    private final String password;

    public DevUserInitializer(
            UserAccountRepository userAccountRepository,
            PasswordEncoder passwordEncoder,
            @Value("${ENTLOOM_DEV_USERNAME:entloom}") String username,
            @Value("${ENTLOOM_DEV_PASSWORD:change-me}") String password) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
        this.username = username;
        this.password = password;
    }

    @Override
    public void run(String... args) {
        if (userAccountRepository.findByUsernameIgnoreCase(username).isEmpty()) {
            userAccountRepository.save(UserAccount.create(
                    username,
                    passwordEncoder.encode(password),
                    "Entloom developer",
                    Set.of("ROLE_ADMIN")));
        }
    }
}
