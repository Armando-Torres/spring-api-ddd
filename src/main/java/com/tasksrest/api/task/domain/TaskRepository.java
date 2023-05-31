package com.tasksrest.api.task.domain;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    
    List<Task> findAll();

    Task findById(Task task);
}
