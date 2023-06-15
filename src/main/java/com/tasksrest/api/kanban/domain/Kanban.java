package com.tasksrest.api.kanban.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Kanban {
    private Integer id;

    private String name;

    private Collection<Column> columns;

    public Kanban() { }

    public Kanban(String name) {
        this.name = name;
        this.columns = new ArrayList<Column>();
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

    public void addColumn(Column column) {
        this.columns.add(column);
    }

    public Boolean deleteColumn(Column column) {
        return this.columns.remove(column);
    }
}
