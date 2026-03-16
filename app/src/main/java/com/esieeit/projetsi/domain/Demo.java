package com.esiee.project.domain;

import java.util.Set;

import com.esiee.project.domain.enums.UserRole;
import com.esiee.project.domain.model.Project;
import com.esiee.project.domain.model.Task;
import com.esiee.project.domain.model.User;

public class Demo {

    public static void main(String[] args) {

        User user = new User(
                "alice@example.com",
                "alice",
                new java.util.HashSet<>(java.util.Arrays.asList(UserRole.USER))
        );

        Project project = new Project(
                "Projet SI",
                "Gestion de projets",
                user
        );

        Task task = new Task(
                "Initialiser le repo",
                "Créer Gradle + README",
                project
        );

        System.out.println(task);

        task.start();
        System.out.println(task);

        task.complete();
        System.out.println(task);

        task.archive();
        System.out.println(task);
    }
}
