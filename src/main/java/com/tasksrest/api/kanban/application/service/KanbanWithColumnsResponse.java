package com.tasksrest.api.kanban.application.service;

import java.util.ArrayList;
import java.util.Collection;

import com.tasksrest.api.kanban.domain.Column;
import com.tasksrest.api.kanban.domain.Kanban;

public class KanbanWithColumnsResponse extends KanbanResponse {
    
    private Collection<ColumnResponse> columns;

    public KanbanWithColumnsResponse(Kanban kanban) {
        super(kanban);
        
        this.columns = this.columnsToColumnResponse(kanban.getColumns());
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
