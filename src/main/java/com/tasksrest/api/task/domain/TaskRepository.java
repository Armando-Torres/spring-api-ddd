package com.tasksrest.api.task.domain;

import java.util.List;

import com.tasksrest.api.task.domain.vo.TasksFilters;

public interface TaskRepository {
    Task save(Task task);
    
    List<Task> findAllWithCriteria(TasksFilters filters);

    Task findById(Integer id);
}
