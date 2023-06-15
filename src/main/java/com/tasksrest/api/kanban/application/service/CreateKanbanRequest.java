package com.tasksrest.api.kanban.application.service;

import java.util.ArrayList;
import java.util.List;

public class CreateKanbanRequest {
    private String name;

    private List<ColumnRequest> columns = new ArrayList<ColumnRequest>();

    public String getName(){
        return this.name;
    }

    public void setName(String value){
        this.name = value;
    }

    public List<ColumnRequest> getColumns() {
        return this.columns;
    }

    public void setColumns(List<ColumnRequest> columns) {
        this.columns = columns;
    }
}
