package com.ebei.eba.common.util;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @Author: Huangweicai
 * @date 2018-02-05 18:22
 * @Description: 请求实体类--分页--内容对象
 *
 *              {@link ResponsePageEx}
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TPageBean<T> {

    private T records;
    private Integer total;
    private Integer size;
    private Integer pages;
    private Integer current;
    
    

    private TPageBean(T t, Integer total,Integer current,Integer size,Integer pages) {
        this.records = t;
        this.total = total;
        this.current = current;
        this.size = size;
        this.pages = pages;
    }
    
    private TPageBean(T t, Integer total) {
        this.records = t;
        this.total = total;
    }

    public static <T> TPageBean<T> createSuccess(T t, Integer total, Integer current, Integer size, Integer pages) {
        return new TPageBean<T>(t,total,current,size,pages);
    }

    public static <T> TPageBean<T> createSuccess(T t, Integer total) {
        return new TPageBean<T>(t,total);
    }

    public T getRecords() {
        return records;
    }

    public void setRecords(T records) {
        this.records = records;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
    
    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }
}
