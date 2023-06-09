package com.tasksrest.api.kanban.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasksrest.api.kanban.domain.Kanban;
import com.tasksrest.api.kanban.domain.KanbanRepository;

public interface KanbanJpaRepository extends JpaRepository<Kanban, Integer>, KanbanRepository{
    
}
