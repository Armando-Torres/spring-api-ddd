package com.tasksrest.api.task.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasksrest.api.task.domain.Task;

public interface TaskJpaRepository extends JpaRepository<Task, Integer> {
    
}
