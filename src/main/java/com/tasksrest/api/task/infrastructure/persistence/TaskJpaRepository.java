package com.tasksrest.api.task.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasksrest.api.task.domain.Task;
import com.tasksrest.api.task.domain.TaskRepository;

@Repository
public interface TaskJpaRepository extends JpaRepository<Task, Integer>, TaskRepository {
    
}
