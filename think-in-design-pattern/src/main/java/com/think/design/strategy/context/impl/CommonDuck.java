package com.think.design.strategy.context.impl;

import com.think.design.strategy.abstractstrategy.impl.FlayWithWings;
import com.think.design.strategy.abstractstrategy.impl.MuteQuack;
import com.think.design.strategy.context.Duck;

/**
 * @author Java男朋友
 * @date 2021-10-29 8:22
 */
public class CommonDuck extends Duck {

    public CommonDuck() {
        flyBehavior = new FlayWithWings();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("我是一只普通的鸭子");
    }
}
