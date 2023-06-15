package com.tasksrest.api.kanban.domain;

import java.util.List;

public interface ColumnRepository {
    List<Column> findAll();

    Column findById(Integer id);

    //KanbanColumn getByKanban(Kanban kanban);

    Column save(Column kanban);
}
