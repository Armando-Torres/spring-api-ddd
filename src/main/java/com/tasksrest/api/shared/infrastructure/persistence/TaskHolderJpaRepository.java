package com.tasksrest.api.shared.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasksrest.api.shared.domain.TaskHolder;
import com.tasksrest.api.shared.domain.TaskHolderRepository;

public interface TaskHolderJpaRepository extends JpaRepository<TaskHolder, Integer>, TaskHolderRepository{
    
}
