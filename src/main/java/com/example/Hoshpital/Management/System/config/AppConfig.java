package com.example.Hoshpital.Management.System.config;

import com.example.Hoshpital.Management.System.entity.User;
import com.example.Hoshpital.Management.System.entity.type.RoleType;
import com.example.Hoshpital.Management.System.repository.AuthRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public CommandLineRunner createAdmin(AuthRepository authRepository) {
        return args -> {
            if (authRepository.findByUsername("admin").isEmpty()) {

                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder().encode("admin123"));
                admin.setRoleTypes(Set.of(RoleType.ROLE_ADMIN));
                authRepository.save(admin);
            }
        };

    }

}
