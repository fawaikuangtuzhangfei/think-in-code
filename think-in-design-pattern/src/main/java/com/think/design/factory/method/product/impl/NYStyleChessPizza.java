package com.think.design.factory.method.product.impl;

import com.think.design.factory.method.product.Pizza;

/**
 * 纽约风味Chess披萨-具体产品
 * @author Java男朋友
 * @date 2021-11-08 8:27
 */
public class NYStyleChessPizza extends Pizza {

    public NYStyleChessPizza(String name, String dough, String sauce) {
        super(name, dough, sauce);
        toppings.add("NYStyleChessPizza toppings");
    }

    @Override
    public void bake() {
        System.out.println("NY bake more time...");
    }
}
