package com.tasksrest.api.shared.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasksrest.api.shared.domain.Task;

public interface TaskJpaRepository extends JpaRepository<Task, Integer> {
    
}
