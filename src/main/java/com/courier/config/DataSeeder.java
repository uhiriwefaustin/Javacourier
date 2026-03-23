package com.courier.config;

import com.courier.model.Role;
import com.courier.model.User;
import com.courier.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            ensureUser(userRepository, passwordEncoder, "admin",   "admin123",   Role.ADMIN);
            ensureUser(userRepository, passwordEncoder, "manager", "manager123", Role.MANAGER);
            ensureUser(userRepository, passwordEncoder, "clerk",   "clerk123",   Role.CLERK);
            ensureUser(userRepository, passwordEncoder, "driver",  "driver123",  Role.DRIVER);
            ensureUser(userRepository, passwordEncoder, "auditor", "auditor123", Role.AUDITOR);

            System.out.println("=== DEFAULT USERS ENSURED ===");
            System.out.println("admin   / admin123   (ADMIN)");
            System.out.println("manager / manager123 (MANAGER)");
            System.out.println("clerk   / clerk123   (CLERK)");
            System.out.println("driver  / driver123  (DRIVER)");
            System.out.println("auditor / auditor123 (AUDITOR)");
            System.out.println("==============================");
        };
    }

    private void ensureUser(UserRepository repo, PasswordEncoder encoder,
                            String username, String password, Role role) {
        User user = repo.findByUsername(username).orElse(new User());
        user.setUsername(username);
        user.setPasswordHash(encoder.encode(password));
        user.setRole(role);
        repo.save(user);
    }
}
