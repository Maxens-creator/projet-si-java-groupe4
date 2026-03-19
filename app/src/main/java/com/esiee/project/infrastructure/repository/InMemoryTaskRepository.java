package com.esiee.project.infrastructure.repository;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import com.esiee.project.application.port.TaskRepository;
import com.esiee.project.domain.model.Task;

@Repository
public class InMemoryTaskRepository implements TaskRepository {

    private final Map<Long, Task> store = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            long id = sequence.incrementAndGet();
            task.setId(id);
        }
        store.put(task.getId(), task);
        return task;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    @Override
    public boolean existsById(Long id) {
        return store.containsKey(id);
    }
}
