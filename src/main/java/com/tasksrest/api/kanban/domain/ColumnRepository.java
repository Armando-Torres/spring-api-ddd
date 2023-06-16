package com.tasksrest.api.kanban.domain;

import java.util.List;
import java.util.Optional;

public interface ColumnRepository {
    List<Column> findAll();

    Optional<Column> findById(Integer id);

    Column save(Column colum);

    void delete(Column colum);
}
