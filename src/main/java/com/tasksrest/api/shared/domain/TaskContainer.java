package com.tasksrest.api.shared.domain;

import java.util.Collection;

import com.tasksrest.api.task.domain.Task;

public abstract class TaskContainer {
    protected Collection<Task> tasks;

    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    public Collection<Task> getTasks() {
        return this.tasks;
    }   
}