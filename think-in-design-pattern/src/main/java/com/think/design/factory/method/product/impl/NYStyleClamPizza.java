package com.think.design.factory.method.product.impl;

import com.think.design.factory.method.product.Pizza;

/**
 * 纽约风味蛤披萨-具体产品
 * @author Java男朋友
 * @date 2021-11-08 8:31
 */
public class NYStyleClamPizza extends Pizza {
    public NYStyleClamPizza(String name, String dough, String sauce) {
        super(name, dough, sauce);
        toppings.add("NYStyleClamPizza toppings");
    }


}
