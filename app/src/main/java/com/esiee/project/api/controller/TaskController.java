package com.esiee.project.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.esiee.project.api.dto.TaskCreateRequest;
import com.esiee.project.api.dto.TaskUpdateRequest;
import com.esiee.project.api.dto.TaskResponse;
import com.esiee.project.api.mapper.TaskMapper;
import com.esiee.project.application.service.TaskService;
import com.esiee.project.domain.model.Task;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponse> getAll() {
        return taskService.getAll().stream()
                .map(TaskMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TaskResponse getById(@PathVariable Long id) {
        Task task = taskService.getById(id);
        return TaskMapper.toResponse(task);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse create(@Valid @RequestBody TaskCreateRequest req) {
        Task task = taskService.create(req);
        return TaskMapper.toResponse(task);
    }

    @PutMapping("/{id}")
    public TaskResponse update(@PathVariable Long id, @Valid @RequestBody TaskUpdateRequest req) {
        Task task = taskService.update(id, req);
        return TaskMapper.toResponse(task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}
