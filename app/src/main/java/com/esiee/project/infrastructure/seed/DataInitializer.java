package com.esiee.project.infrastructure.seed;

import com.esiee.project.domain.entity.Project;
import com.esiee.project.domain.entity.Task;
import com.esiee.project.domain.entity.User;
import com.esiee.project.domain.enums.TaskStatus;
import com.esiee.project.infrastructure.repository.ProjectRepository;
import com.esiee.project.infrastructure.repository.TaskRepository;
import com.esiee.project.infrastructure.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInitializer {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public DataInitializer(UserRepository userRepository,
                           ProjectRepository projectRepository,
                           TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    @Bean
    CommandLineRunner initData() {
        return args -> {
            if (userRepository.count() > 0) return;

            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@test.com");
            admin.setPassword("1234");
            admin.setRole("ROLE_ADMIN");

            User user1 = new User();
            user1.setUsername("alice");
            user1.setEmail("alice@test.com");
            user1.setPassword("1234");
            user1.setRole("ROLE_USER");

            userRepository.saveAll(List.of(admin, user1));

            Project project = new Project();
            project.setName("Projet Test");
            project.setOwner(admin);
            projectRepository.save(project);

            Task task = new Task();
            task.setTitle("Première tâche");
            task.setStatus(TaskStatus.TODO);
            task.setProject(project);
            task.setDueDate(LocalDate.now().plusDays(2));
            taskRepository.save(task);
        };
    }
}
