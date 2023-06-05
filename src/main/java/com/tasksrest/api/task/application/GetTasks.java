package com.tasksrest.api.task.application;

import java.util.List;

import com.tasksrest.api.task.domain.Task;
import com.tasksrest.api.task.domain.TaskRepository;
import com.tasksrest.api.task.domain.vo.TasksFilters;

public class GetTasks {
    private final TaskRepository repository;

    public GetTasks(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> invoke(TasksFilters filters) { 
        List<Task> tasks = this.repository.findAllWithCriteria(filters);
        
        return tasks;
    }
}
