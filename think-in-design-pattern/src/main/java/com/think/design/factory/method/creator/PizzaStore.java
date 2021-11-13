package com.think.design.factory.method.creator;

import com.think.design.factory.method.product.Pizza;

/**
 * 披萨商店-基类
 * @author Java男朋友
 * @date 2021-11-08 8:32
 */
public abstract class PizzaStore {

    public Pizza pizza;

    public void orderPizza(String type){
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    public abstract Pizza createPizza(String type);
}
