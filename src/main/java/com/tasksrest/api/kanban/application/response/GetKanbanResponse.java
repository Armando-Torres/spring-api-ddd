package com.tasksrest.api.kanban.application.response;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.tasksrest.api.kanban.domain.Kanban;
import com.tasksrest.api.kanban.domain.Column;

public class GetKanbanResponse {
    private Integer id;
    
    private String name;

    private Collection<Object> columns;
    
    public GetKanbanResponse(Kanban kanban) {
        this.id = kanban.getId();
        this.name = kanban.getName();
        this.columns = this.getColumns(kanban.getColumns());
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Collection<Object> getColumns() {
        return this.columns;
    }

    private Collection<Object> getColumns(Collection<Column> columns) {
        Collection<Object> kanbanColumns = new ArrayList<Object>();

        for (Column column : columns) {
            HashMap<String, Object> element = new HashMap<>();

            element.put("name", column.getName());
            element.put("wip", column.getWip());
            element.put("order", column.getOrder());

            kanbanColumns.add(element);
        }

        return kanbanColumns;
    }
}
