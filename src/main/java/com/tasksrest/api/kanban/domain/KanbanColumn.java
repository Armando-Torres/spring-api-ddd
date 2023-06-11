package com.tasksrest.api.kanban.domain;

import com.tasksrest.api.shared.domain.TaskContainer;

public class KanbanColumn extends TaskContainer{
    private Integer id;

    private Integer order;

    private String name;

    private Integer wip;

    private Kanban kanban;

    public KanbanColumn() {

    }

    public KanbanColumn(Integer order, String name, Integer wip, Kanban kanban) {
        this.order = order;
        this.name = name;
        this.wip = wip;
        this.kanban = kanban;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getOrder() {
        return this.order;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setWip(Integer wip) {
        this.wip = wip;
    }

    public Integer getWip() {
        return this.wip;
    }

    public void setKanban(Kanban kanban) {
        this.kanban = kanban;
    }

    public Kanban getKanban() {
        return this.kanban;
    }
}
