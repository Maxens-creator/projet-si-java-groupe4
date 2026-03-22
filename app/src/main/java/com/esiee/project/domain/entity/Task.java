package com.esiee.project.domain.entity;

import com.esiee.project.domain.enumtype.TaskPriority;
import com.esiee.project.domain.enumtype.TaskStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.TODO;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority = TaskPriority.MEDIUM;

    @ManyToOne
    private Project project;

    public Task() {}

    // ⚠️ IMPORTANT (corrige ton bug)
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() { return id; }
}
