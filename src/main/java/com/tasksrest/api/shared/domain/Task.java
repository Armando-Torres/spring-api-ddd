package com.tasksrest.api.shared.domain;

import com.tasksrest.api.shared.domain.vo.TaskStatus;

public final class Task {
    private Integer id;

    private String name;

    private String description;

    private TaskStatus status;

    private TaskHolder taskHolder;

    //private User user;

    public Task() {
        // Default constructor is required for JPA
    }

    public Task(String name, String description, String status/*, User user*/) {
        this.name = name;
        this.description = description;
        this.status = new TaskStatus(status.toUpperCase());
        //this.user = user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public void setStatus(String status) {
        this.status = new TaskStatus(status);
    }

    public String getStatus() {
        return (this.status != null) ? this.status.getValue() : null;
    }

    public void setTaskHolder(TaskHolder taskHolder) {
        this.taskHolder = taskHolder;
    }

    public TaskHolder getTaskHolder(){
        return this.taskHolder;
    }
    
}