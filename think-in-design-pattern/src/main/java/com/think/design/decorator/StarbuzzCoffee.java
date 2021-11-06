package com.think.design.decorator;

import com.think.design.decorator.component.Beverage;
import com.think.design.decorator.component.impl.HouseBlend;
import com.think.design.decorator.decorator.impl.Mocha;
import com.think.design.decorator.decorator.impl.Soy;
import com.think.design.decorator.decorator.impl.Whip;

/**
 * 装饰者模式
 * @author Java男朋友
 * @date 2021-11-03 22:37
 */
public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage houseBlend = new HouseBlend();
        System.out.println(houseBlend.getDescription() + ":" + houseBlend.cost());
        System.out.println("===================================");
        Beverage mocha = new Mocha(new Soy(new Whip(houseBlend)));
        System.out.println(mocha.getDescription() + ":" + mocha.cost());
        System.out.println("===================================");
        Beverage mocha2 = new Mocha(new Soy(new Whip(new Whip(houseBlend))));
        mocha2.getDescription();
        System.out.println(mocha2.getDescription() + ":" + mocha2.cost());
    }
}
