package com.think.design.iterator.base;

/**
 * 菜单项
 * @author Java男朋友
 * @date 2022-01-12 7:44
 */
public class MenuItem {

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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
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
}
