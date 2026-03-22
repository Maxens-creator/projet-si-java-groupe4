package com.esiee.project.domain.entity;

import com.esiee.project.domain.enumtype.ProjectStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status = ProjectStatus.DRAFT;

    @ManyToOne
    private User owner;

    public Project() {}
}
