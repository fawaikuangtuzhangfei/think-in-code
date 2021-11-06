package com.think.design.decorator.decorator;

import com.think.design.decorator.component.Beverage;

/**
 * 装饰者-超类
 * @author Java男朋友
 * @date 2021-11-03 22:25
 */
public abstract class CondimentDecorator extends Beverage {

    @Override
    public abstract double cost();


}
