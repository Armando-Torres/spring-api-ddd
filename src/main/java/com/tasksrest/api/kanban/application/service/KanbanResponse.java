package com.tasksrest.api.kanban.application.service;

import com.tasksrest.api.kanban.domain.Kanban;

public class KanbanResponse {
    private Integer id;
    
    private String name;
    
    public KanbanResponse(Kanban kanban) {
        this.id = kanban.getId();
        this.name = kanban.getName();
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
