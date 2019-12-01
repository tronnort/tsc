package com.tron.web.jdbctemplate;


import java.util.ArrayList;
import java.util.List;


public class MyPage {
    private int showRows = 50; //每页显示条数
    private int page;   //当前页
    private int totalRows;   //总行数
    private int pages;    //总页数
    private List list=new ArrayList();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getShowRows() {
        return showRows;
    }

    public void setShowRows(int showRows) {
        this.showRows = showRows;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
