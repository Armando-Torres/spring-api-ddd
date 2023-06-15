package com.tasksrest.api.kanban.application.service;


public class CreateKanbanRequest {
    private String name;

    //private List<CreateKanbanColumnRequest> columns;

    public String getName(){
        return this.name;
    }

    public void setName(String value){
        this.name = value;
    }

    /*public List<CreateKanbanColumnRequest> getColumns() {
        return this.columns;
    }

    public void setColumns(List<CreateKanbanColumnRequest> columns) {
        this.columns = columns;
    }*/
}
