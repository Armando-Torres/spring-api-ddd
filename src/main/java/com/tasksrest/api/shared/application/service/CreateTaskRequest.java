package com.tasksrest.api.shared.application.service;

public class CreateTaskRequest extends TaskRequest{
    private Integer taskHolderId;

    public Integer getTaskHolderId() {
        return this.taskHolderId;
    }

    public void setTaskHolderId(Integer id) {
        this.taskHolderId = id;
    }
}
