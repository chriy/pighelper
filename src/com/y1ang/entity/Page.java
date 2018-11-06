package com.y1ang.entity;

/**
 * 
 * @author y1ang
 * @Data 2018年10月13日-上午10:36:30
 * @Description 分页POJO类
 */
public class Page {

    private Integer page;

    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Page(Integer page, Integer limit) {
        super();
        this.page = page;
        this.limit = limit;
    }

    public Page() {
        super();
    }

}
