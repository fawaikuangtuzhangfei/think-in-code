package com.think.design.factory.method.creator.impl;

import com.think.design.factory.enmu.PizzaType;
import com.think.design.factory.method.creator.PizzaStore;
import com.think.design.factory.method.product.Pizza;
import com.think.design.factory.method.product.impl.NYStyleChessPizza;
import com.think.design.factory.method.product.impl.NYStyleClamPizza;

/**
 * 纽约披萨店-具体创建者
 * @author Java男朋友
 * @date 2021-11-08 8:36
 */
public class NYPizzaStore extends PizzaStore {


    @Override
    public Pizza createPizza(String type) {
        if(PizzaType.CHESS.getCode().equals(type)){
            pizza = new NYStyleChessPizza(PizzaType.CHESS.getName(), "nY面团", "NYSauce");
        }else if(PizzaType.CLAM.getCode().equals(type)){
            pizza = new NYStyleClamPizza(PizzaType.CLAM.getName(), "Clam 面团", "clam 调味");
        }
        return pizza;
    }
}
