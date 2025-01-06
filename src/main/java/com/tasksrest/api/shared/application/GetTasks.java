package com.tasksrest.api.shared.application;

import java.util.List;

import com.tasksrest.api.shared.application.service.TaskResponse;
import com.tasksrest.api.shared.domain.Task;
import com.tasksrest.api.shared.domain.TaskRepository;
import com.tasksrest.api.shared.domain.vo.TasksFilters;

public class GetTasks {
    private final TaskRepository repository;

    public GetTasks(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskResponse> invoke(TasksFilters filters) { 
        List<Task> tasks = this.repository.findAllWithCriteria(filters);
        
        return tasks.stream()
            .map(task -> { return new TaskResponse(task); })
            .toList();
    }
}
