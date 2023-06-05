package com.tasksrest.api.shared.domain.vo;

public class Pagination {
    private Integer page;
    private Integer size;

    public Pagination(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public Integer getPage() {
        return this.page;
    }

    public Integer getSize() {
        return this.size;
    }
}
