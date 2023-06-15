package com.tasksrest.api.kanban.domain;

import java.util.List;

public interface ColumnRepository {
    List<Column> findAll();

    Column findById(Integer id);

    Column save(Column column);

    void delete(Column column);
}
