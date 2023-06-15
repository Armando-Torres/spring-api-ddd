package com.tasksrest.api.kanban.application.service;

import java.util.List;

public class CreateKanbanRequest {
    private String name;

    private List<AddColumnRequest> columns;

    public String getName(){
        return this.name;
    }

    public void setName(String value){
        this.name = value;
    }

    public List<AddColumnRequest> getColumns() {
        return this.columns;
    }

    public void setColumns(List<AddColumnRequest> columns) {
        this.columns = columns;
    }
}
