package com.think.design.decorator.component;

/**
 * 组件
 * 饮料-基类
 * @author Java男朋友
 * @date 2021-11-03 22:22
 */
public abstract class Beverage {

    protected String description = "Unknown Beverage";

    protected Integer size;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
