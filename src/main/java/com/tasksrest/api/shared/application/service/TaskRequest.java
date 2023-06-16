package com.tasksrest.api.shared.application.service;

public class CreateTaskRequest {
    private String name;

    private String desc;

    private String status;

    public String getName(){
        return this.name;
    }

    public void setName(String value){
        this.name = value;
    }

    public String getDesc(){
        return this.desc;
    }

    public void setDesc(String value){
        this.desc = value;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String value){
        this.status = value;
    }
}
