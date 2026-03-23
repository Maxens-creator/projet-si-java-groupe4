package com.esiee.project.infrastructure.repository;

import com.esiee.project.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByNameContainingIgnoreCase(String keyword);

    List<Project> findByOwnerId(Long ownerId);

    boolean existsByName(String name);
}
