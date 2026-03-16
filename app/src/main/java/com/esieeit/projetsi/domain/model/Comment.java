package com.esiee.project.domain.model;

import java.util.Objects;

import com.esiee.project.domain.validation.Validators;

public class Comment {

    private Long id;
    private String content;
    private Task task;
    private User author;

    public Comment(String content, Task task, User author) {
        setContent(content);
        setTask(task);
        setAuthor(author);
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getContent() { return content; }

    public final void setContent(String content) {
        this.content = Validators.requireNonBlank(content, "comment.content", 1, 500);
    }

    public Task getTask() { return task; }

    public final void setTask(Task task) {
        Validators.requireNonNull(task, "comment.task");
        this.task = task;
    }

    public User getAuthor() { return author; }

    public final void setAuthor(User author) {
        Validators.requireNonNull(author, "comment.author");
        this.author = author;
    }

    @Override
    public String toString() {
        return "Comment{id=" + id + ", author=" + author.getUsername() + ", content='" + content + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
