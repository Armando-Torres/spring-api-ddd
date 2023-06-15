package com.tasksrest.api.kanban.application.service;

import com.tasksrest.api.kanban.domain.Column;

public class ColumnResponse {
    private Integer id;
    
    private String name;

    private Integer order;

    private Integer wip;

    private Integer kanban;
    
    public ColumnResponse(Column column) {
        this.id = column.getId();
        this.name = column.getName();
        this.order = column.getOrder();
        this.wip = column.getWip();
        this.kanban = column.getKanban().getId();
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getOrder() {
        return this.order;
    }

    public Integer getWip() {
        return this.wip;
    }

    public Integer getKanban() {
        return this.kanban;
    }
}
