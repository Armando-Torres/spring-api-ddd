package com.tasksrest.api.shared.domain;

import java.util.Collection;

public abstract class TaskContainer {
    private Integer id;

    private Integer order;

    private String name;

    private Collection<Task> tasks;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getOrder() {
        return this.order;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    public Collection<Task> getTasks() {
        return this.tasks;
    }
}