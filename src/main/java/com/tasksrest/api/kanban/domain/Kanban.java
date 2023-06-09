package com.tasksrest.api.kanban.domain;

import java.util.Collection;

public class Kanban {
    private Integer id;

    private String name;

    private Collection<Column> columns;

    public Kanban() {

    }

    public Kanban(String name) {
        this.name = name;
    }

    public Kanban(String name, Collection<Column> columns) {
        this.name = name;
        this.columns = columns;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Column> getColumns() {
        return this.columns;
    }

    public void setColumns(Collection<Column> columns) {
        this.columns = columns;
    }
}
