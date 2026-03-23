package com.esiee.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import com.esiee.project.domain.entity.User;
import com.esiee.project.infrastructure.repository.UserRepository;

@SpringBootApplication
public class ProjectSiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectSiApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(UserRepository userRepository) {
        return args -> {
            // Seed minimal si la table est vide
            if (userRepository.count() == 0) {

                // Utilisateur admin
                User admin = new User();
                admin.setUsername("admin");
                admin.setEmail("admin@esiee.local");
                admin.setPassword("CHANGE_ME_HASH_LATER"); // à remplacer par mot de passe hashé
                admin.setRole("ROLE_ADMIN");

                // Utilisateur classique
                User alice = new User();
                alice.setUsername("alice");
                alice.setEmail("alice@esiee.local");
                alice.setPassword("CHANGE_ME_HASH_LATER");
                alice.setRole("ROLE_USER");

                // Sauvegarde
                userRepository.save(admin);
                userRepository.save(alice);

                System.out.println("Seed utilisateurs insérés : admin et alice");
            }
        };
    }
}
