package com.esiee.project.infrastructure.repository;

import com.esiee.project.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
