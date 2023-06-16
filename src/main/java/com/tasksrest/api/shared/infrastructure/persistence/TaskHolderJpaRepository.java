package com.tasksrest.api.shared.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasksrest.api.kanban.domain.Column;
import com.tasksrest.api.kanban.domain.ColumnRepository;
import com.tasksrest.api.shared.domain.TaskHolderRepository;

public interface TaskHolderJpaRepository extends JpaRepository<Column, Integer>, TaskHolderRepository{
    
}
