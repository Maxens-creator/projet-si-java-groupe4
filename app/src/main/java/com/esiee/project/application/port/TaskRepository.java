package com.esiee.project.application.port;

import java.util.List;
import java.util.Optional;
import com.esiee.project.domain.model.Task;

public interface TaskRepository {

    Task save(Task task);

    Optional<Task> findById(Long id);

    List<Task> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
