package com.think.design.factory.method.product.impl;

import com.think.design.factory.method.product.Pizza;

/**
 * @author Java男朋友
 * @date 2021-11-13 11:06
 */
public class ChicagoStykeChessPizza extends Pizza {

    public ChicagoStykeChessPizza(String name, String dough, String sauce) {
        super(name, dough, sauce);
        toppings.add("NYStyleChessPizza toppings");
    }

    @Override
    public void bake() {
        System.out.println("CHI bake less time...");
    }

    @Override
    public void cut() {
        System.out.println("i like cut circle");
    }
}
