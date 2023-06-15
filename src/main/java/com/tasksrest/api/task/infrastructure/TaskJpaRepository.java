package com.tasksrest.api.task.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasksrest.api.shared.domain.Task;

public interface TaskJpaRepository extends JpaRepository<Task, Integer> {
    
}
