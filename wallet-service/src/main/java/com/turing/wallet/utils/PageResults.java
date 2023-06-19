package com.turing.wallet.utils;

import java.io.Serializable;
import java.util.List;

public class PageResults implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<?> list; // 返回每页的数据的集合
    private long totalPage;//最大页
    private long totalRow;//总条数

    public long getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(long totalRow) {
        this.totalRow = totalRow;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public PageResults(List<?> list, long totalPage) {
        super();
        this.list = list;
        this.totalPage = totalPage;
    }

    public PageResults(List<?> list, long totalPage, long totalRow) {
        super();
        this.list = list;
        this.totalPage = totalPage;
        this.totalRow = totalRow;
    }


}
