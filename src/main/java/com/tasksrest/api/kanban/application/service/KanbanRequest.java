package com.tasksrest.api.kanban.application.service;

public class KanbanRequest {
    private String name;

    public String getName(){
        return this.name;
    }

    public void setName(String value){
        this.name = value;
    }
}
