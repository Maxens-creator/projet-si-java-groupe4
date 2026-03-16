package com.esiee.project.domain.model;

import java.util.Objects;

import com.esiee.project.domain.enums.TaskStatus;
import com.esiee.project.domain.exception.BusinessRuleException;
import com.esiee.project.domain.validation.Validators;

public class Task {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Project project;
    private User assignee;

    public Task(String title, String description, Project project) {
        setTitle(title);
        setDescription(description);
        setProject(project);
        this.status = TaskStatus.TODO;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public final void setTitle(String title) {
        this.title = Validators.requireNonBlank(title, "task.title", 1, 120);
    }

    public String getDescription() { return description; }

    public final void setDescription(String description) {
        if (description == null) {
            this.description = null;
            return;
        }

        String d = description.trim();
        this.description = d.isEmpty() ? null :
                Validators.requireSize(d, "task.description", 0, 1000);
    }

    public TaskStatus getStatus() { return status; }

    public Project getProject() { return project; }

    public final void setProject(Project project) {
        Validators.requireNonNull(project, "task.project");
        this.project = project;
    }

    public User getAssignee() { return assignee; }

    public void assignTo(User user) {
        Validators.requireNonNull(user, "task.assignee");
        this.assignee = user;
    }

    public void unassign() {
        this.assignee = null;
    }

    public void start() {
        if (status != TaskStatus.TODO) {
            throw new BusinessRuleException(
                    "Transition interdite: start() possible uniquement depuis TODO"
            );
        }
        status = TaskStatus.IN_PROGRESS;
    }

    public void complete() {
        if (status != TaskStatus.IN_PROGRESS) {
            throw new BusinessRuleException(
                    "Transition interdite: complete() possible uniquement depuis IN_PROGRESS"
            );
        }
        status = TaskStatus.DONE;
    }

    public void archive() {
        if (status != TaskStatus.DONE) {
            throw new BusinessRuleException(
                    "Transition interdite: archive() possible uniquement depuis DONE"
            );
        }
        status = TaskStatus.ARCHIVED;
    }

    @Override
    public String toString() {
        return "Task{id=" + id + ", title='" + title + "', status=" + status + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
