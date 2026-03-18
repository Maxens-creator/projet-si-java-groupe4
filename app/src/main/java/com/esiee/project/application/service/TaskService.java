package com.esiee.project.application.service;

import com.esiee.project.domain.model.Task;
import com.esiee.project.infrastructure.repository.InMemoryTaskRepository;

import java.util.List;
import java.util.Optional;

public class TaskService {

    private final InMemoryTaskRepository repository = new InMemoryTaskRepository();

    public List<Task> findAll() { return repository.findAll(); }

    public Optional<Task> findById(Long id) { return repository.findById(id); }

    public Task create(Task task) { return repository.save(task); }

    public Task update(Task task) { return repository.save(task); }

    public void delete(Long id) { repository.delete(id); }
}
