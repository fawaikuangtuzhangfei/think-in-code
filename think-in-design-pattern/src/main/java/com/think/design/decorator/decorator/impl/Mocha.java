package com.think.design.decorator.decorator.impl;

import com.think.design.decorator.BeverageSizeEnum;
import com.think.design.decorator.component.Beverage;
import com.think.design.decorator.decorator.CondimentDecorator;

/**
 * 摩卡-装饰者
 * @author Java男朋友
 * @date 2021-11-03 22:31
 */
public class Mocha extends CondimentDecorator {

    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.description = "Mocha";
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + " + this.description;
    }

    @Override
    public double cost() {
        double cost = 0.20;
        if(getSize().equals(BeverageSizeEnum.TALL.getSize())){
            cost += 0.5;
        }else if(getSize().equals(BeverageSizeEnum.MID.getSize())){
            cost += 0.3;
        }
        return beverage.cost() + cost;
    }
}
