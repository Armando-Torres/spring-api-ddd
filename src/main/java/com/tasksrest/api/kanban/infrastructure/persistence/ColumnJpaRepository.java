package com.tasksrest.api.kanban.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasksrest.api.kanban.domain.Column;
import com.tasksrest.api.kanban.domain.ColumnRepository;

public interface ColumnJpaRepository extends JpaRepository<Column, Integer>, ColumnRepository{

}
