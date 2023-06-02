package com.tasksrest.api.task.application;

import java.util.List;
import java.util.Map;

import com.tasksrest.api.task.domain.Task;
import com.tasksrest.api.task.domain.TaskRepository;

public class GetTasks {
    private final TaskRepository repository;

    public GetTasks(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> invoke(Map<String,String> filters) { 
        // TODO Filters mapping in repository method??
        List<Task> tasks = this.repository.findAll();
        
        return tasks;
    }
}
