package com.tasksrest.api.kanban.application.service;

import java.util.ArrayList;
import java.util.Collection;

import com.tasksrest.api.kanban.domain.Column;
import com.tasksrest.api.kanban.domain.Kanban;

public class KanbanResponse {
    private Integer id;
    
    private String name;

    private Collection<ColumnResponse> columns;
    
    public KanbanResponse(Kanban kanban) {
        this.id = kanban.getId();
        this.name = kanban.getName();
        this.columns = this.columnsToColumnResponse(kanban.getColumns());
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setColumns(Collection<ColumnResponse> kanbanColumns) {
        this.columns = kanbanColumns;
    }

    public Collection<ColumnResponse> getColumns() {
        return this.columns;
    }

    private Collection<ColumnResponse> columnsToColumnResponse(Collection<Column> columns) {
        Collection<ColumnResponse> kanbanColumns = new ArrayList<ColumnResponse>();

        for (Column column : columns) {
            ColumnResponse columnResponse = new ColumnResponse(column);

            kanbanColumns.add(columnResponse);
        }

        return kanbanColumns;
    }
}
