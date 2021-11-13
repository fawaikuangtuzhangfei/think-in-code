package com.think.design.factory.method;

import com.think.design.factory.enmu.PizzaType;
import com.think.design.factory.method.creator.PizzaStore;
import com.think.design.factory.method.creator.impl.ChicagoPizzaStore;
import com.think.design.factory.method.creator.impl.NYPizzaStore;

/**
 * @author Java男朋友
 * @date 2021-11-13 10:54
 */
public class PizzaTestDrive {

    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStore();
        pizzaStore.orderPizza(PizzaType.CLAM.getCode());

        System.out.println("let go ----------------------");

        pizzaStore = new ChicagoPizzaStore();
        pizzaStore.orderPizza(PizzaType.CHESS.getCode());

    }
}
