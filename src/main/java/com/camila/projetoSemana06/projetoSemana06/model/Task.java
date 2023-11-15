package com.camila.projetoSemana06.projetoSemana06.model;

import ch.qos.logback.core.status.Status;
import jakarta.annotation.Priority;

public class Task {
    private Long id;
    private String description;
    private Status status;
    private Priority priority;
    private String assignee;

    // Construtor vazio
    public Task() {
    }

    // Construtor com todos os atributos
    public Task(Long id, String description, Status status, Priority priority, String assignee) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assignee = assignee;
    }

    // Métodos Getters e Setters para os atributos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
}

