package com.tasksrest.api.kanban.domain;

import java.util.List;
import java.util.Optional;

public interface KanbanRepository {
    List<Kanban> findAll();

    Optional<Kanban> findById(Integer id);

    Kanban save(Kanban kanban);
}
