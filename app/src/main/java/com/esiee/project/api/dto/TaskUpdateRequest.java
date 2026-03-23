package com.esiee.project.api.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TaskUpdateRequest {
    @Size(min = 3, max = 120)
    private String title;

    @Size(max = 2000)
    private String description;

    @Pattern(regexp = "TODO|IN_PROGRESS|DONE")
    private String status;

    // getters et setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
