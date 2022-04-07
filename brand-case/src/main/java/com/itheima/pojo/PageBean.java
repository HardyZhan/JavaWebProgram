package com.itheima.pojo;

import java.util.List;

public class PageBean<T> {

    private int totalCount;

    private List<T> rows;

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public List<T> getRows() {
        return rows;
    }
}
