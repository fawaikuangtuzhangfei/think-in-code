package com.think.design.component.component.impl;

import com.think.design.component.component.MenuComponent;
import com.think.design.component.iterators.NullIterator;

import java.util.Iterator;

/**
 * @author Java男朋友
 * @date 2022-02-23 18:30
 */
public class MenuItem extends MenuComponent {

    String name;		//名称
    String description;	//叙述
    boolean vegetarian;	//是否为素食
    double price;		//价格

    /*
     * 将这些值传入构造器来初始化这个菜单项
     */
    public MenuItem(String name, String description, boolean vegetarian,
                    double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", vegetarian=" + vegetarian +
                ", price=" + price +
                '}';
    }

    @Override
    public void print() {
        System.out.println(toString());
    }
}
