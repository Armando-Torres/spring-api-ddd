package com.tasksrest.api.kanban.application.service;

public class AddColumnRequest {
    private String name;

    private Integer wip;

    private Integer order;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWip() {
        return this.wip;
    }

    public void setWip(Integer wip) {
        this.wip = wip;
    }

    public Integer getOrder() {
        return this.order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
