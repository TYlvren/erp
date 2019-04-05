package com.cskaoyan.erp.util;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageModel<T> {
    private long total;
    private List<T> rows;

    public PageModel(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        rows = pageInfo.getList();
        total = pageInfo.getTotal();
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

}
