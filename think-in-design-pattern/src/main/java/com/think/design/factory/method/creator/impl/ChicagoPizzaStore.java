package com.think.design.factory.method.creator.impl;

import com.think.design.factory.enmu.PizzaType;
import com.think.design.factory.method.creator.PizzaStore;
import com.think.design.factory.method.product.Pizza;
import com.think.design.factory.method.product.impl.ChicagoStykeChessPizza;
import com.think.design.factory.method.product.impl.NYStyleClamPizza;

/**
 * 芝加哥披萨店-具体创建者
 * @author Java男朋友
 * @date 2021-11-13 11:02
 */
public class ChicagoPizzaStore extends PizzaStore {


    @Override
    public Pizza createPizza(String type) {
        if(PizzaType.CHESS.getCode().equals(type)){
            pizza = new ChicagoStykeChessPizza("Chicago" + PizzaType.CHESS.getName(), "Chicago 面团", "Chicago source");
        }else if(PizzaType.CLAM.getCode().equals(type)){
            pizza = new NYStyleClamPizza(PizzaType.CLAM.getName(), "Chicago 面团", "Chicago 调味");
        }
        return pizza;
    }
}
