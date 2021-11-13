package com.think.design.factory.method.product;

import java.util.ArrayList;

/**
 * 基类-产品类
 * 披萨
 * @author Java男朋友
 * @date 2021-11-08 8:22
 */
public abstract class Pizza {

    protected String name;
    protected String dough;
    protected String sauce;
    protected ArrayList<String> toppings = new ArrayList<>();

    public Pizza(String name, String dough, String sauce) {
        this.name = name;
        this.dough = dough;
        this.sauce = sauce;
    }

    public void prepare(){
        System.out.println("Preparing " + name);
        System.out.println("Tossing " + dough);
        System.out.println("Adding " + sauce);
        toppings.forEach(obj-> System.out.println(" " + obj));
    }

    public void bake(){
        System.out.println("BAKE ....");
    }

    public void cut(){
        System.out.println("CUT ....");
    }

    public void box(){
        System.out.println("BOX ....");
    }

}
