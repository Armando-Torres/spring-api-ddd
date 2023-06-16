package com.tasksrest.api.shared.application.service;

public class TaskRequest {
    private String name;

    private String desc;

    private String status;

    private Integer order;

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

    public Integer getOrder() {
        return this.order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
