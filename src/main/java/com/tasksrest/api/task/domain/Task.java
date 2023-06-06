package com.tasksrest.api.task.domain;

import com.tasksrest.api.task.domain.vo.Status;

public final class Task {
    private Integer id;

    private String name;

    private String description;

    private Status status;

    //private User user;

    public Task() {
        // Default constructor is required for JPA
    }

    public Task(String name, String description, String status/*, User user*/) {
        this.name = name;
        this.description = description;
        this.status = new Status(status.toUpperCase());
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
        this.status = new Status(status);
    }

    public String getStatus() {
        return (this.status != null) ? this.status.getValue() : null;
    }
}