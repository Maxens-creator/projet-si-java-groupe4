package com.esiee.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import com.esiee.project.domain.entity.User;
import com.esiee.project.domain.enumtype.Role;
import com.esiee.project.infrastructure.repository.UserRepository;

@SpringBootApplication
public class ProjectSiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectSiApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                User user = new User(
                    "alice",
                    "alice@example.com",
                    "temp-hash",
                    Role.ROLE_USER
                );
                userRepository.save(user);
                System.out.println("Utilisateur de test inséré");
            }
        };
    }
}
