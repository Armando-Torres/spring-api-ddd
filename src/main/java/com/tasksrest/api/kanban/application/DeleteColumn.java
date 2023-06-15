package com.tasksrest.api.kanban.application;

import com.tasksrest.api.kanban.domain.Column;
import com.tasksrest.api.kanban.domain.ColumnRepository;
import com.tasksrest.api.kanban.domain.exception.NotFoundColumnException;

public class DeleteColumn {
    private final ColumnRepository kanbanColumnRepository;

    private final String NOT_FOUND = "Column not found";

    public DeleteColumn(ColumnRepository kanbanColumnRepository) {
        this.kanbanColumnRepository = kanbanColumnRepository;
    }

    public void invoke(Integer columnId){ 
        Column column = this.kanbanColumnRepository.findById(columnId);

        if (column == null) {
            throw new NotFoundColumnException(NOT_FOUND);
        }

        this.kanbanColumnRepository.delete(column);
    }
}
