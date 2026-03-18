package com.esiee.project.infrastructure.repository;

import com.esiee.project.domain.model.Task;

import java.util.*;

public class InMemoryTaskRepository {

    private final Map<Long, Task> store = new HashMap<>();
    private long sequence = 0;

    public List<Task> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Task save(Task task) {
        if (task.getId() == null) {
            sequence++;
            task.setId(sequence);
        }
        store.put(task.getId(), task);
        return task;
    }

    public void delete(Long id) {
        store.remove(id);
    }
}
