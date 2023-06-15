package com.tasksrest.api.kanban.application.service;

import java.util.ArrayList;
import java.util.List;

public class CreateKanbanRequest extends KanbanRequest {
    private List<ColumnRequest> columns = new ArrayList<ColumnRequest>();

    public List<ColumnRequest> getColumns() {
        return this.columns;
    }

    public void setColumns(List<ColumnRequest> columns) {
        this.columns = columns;
    }
}
