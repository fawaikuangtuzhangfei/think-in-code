package com.think.design.decorator.decorator.impl;

import com.think.design.decorator.component.Beverage;
import com.think.design.decorator.decorator.CondimentDecorator;

/**
 * 牛奶-装饰者
 * @author Java男朋友
 * @date 2021-11-03 22:36
 */
public class Whip extends CondimentDecorator {

    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.description = "Whip";
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + " + this.description;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }

}
