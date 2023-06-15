package com.tasksrest.api.kanban.domain;

import java.util.List;

public interface KanbanRepository {
    List<Kanban> findAll();

    Kanban findById(Integer id);

    Kanban save(Kanban kanban);
}
