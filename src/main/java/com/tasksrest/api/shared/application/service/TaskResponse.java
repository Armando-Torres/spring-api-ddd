package com.tasksrest.api.shared.application.service;

import com.tasksrest.api.shared.domain.Task;

public class TaskResponse {
    private Integer id;

    private String name;

    private String description;

    private Integer order;

    private String status;

    private Integer holderId;

    public TaskResponse(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.description = task.getDescription();
        this.order = task.getOrder();
        this.status = task.getStatus();
        this.holderId = task.getTaskHolder().getId();
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getOrder() {
        return this.order;
    }

    public String getStatus() {
        return this.status;
    }

    public Integer getHolderId() {
        return this.holderId;
    }
}
