package com.esiee.project.application.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.esiee.project.api.dto.TaskCreateRequest;
import com.esiee.project.api.dto.TaskUpdateRequest;
import com.esiee.project.application.port.TaskRepository;
import com.esiee.project.domain.exception.ResourceNotFoundException;
import com.esiee.project.domain.model.Task;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(TaskCreateRequest req) {
        Task task = new Task(req.getTitle(), req.getDescription());
        return taskRepository.save(task);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task introuvable: id=" + id));
    }

    public Task update(Long id, TaskUpdateRequest req) {
        Task task = getById(id);

        if (req.getTitle() != null) {
            task.setTitle(req.getTitle());
        }

        if (req.getDescription() != null) {
            task.setDescription(req.getDescription());
        }

        return taskRepository.save(task);
    }

    public void delete(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Task introuvable: id=" + id);
        }
        taskRepository.deleteById(id);
    }
}
