package com.think.design.decorator.decorator.impl;

import com.think.design.decorator.component.Beverage;
import com.think.design.decorator.decorator.CondimentDecorator;

/**
 * 豆浆-装饰者
 * @author Java男朋友
 * @date 2021-11-03 22:35
 */
public class Soy extends CondimentDecorator {
    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.description = "Soy";
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + " + this.description;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.15;
    }
}
