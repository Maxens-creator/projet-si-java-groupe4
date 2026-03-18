package com.esiee.project.api.mapper;

import com.esiee.project.api.dto.TaskResponse;
import com.esiee.project.domain.model.Task;

public class TaskMapper {
    public static TaskResponse toResponse(Task task) {
        return new TaskResponse(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getStatus().name()
        );
    }
}
