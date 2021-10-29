package com.think.design.strategy.context.impl;

import com.think.design.strategy.abstractstrategy.impl.FlayWithWings;
import com.think.design.strategy.abstractstrategy.impl.MuteQuack;
import com.think.design.strategy.context.Duck;

/**
 * 环境类-可达鸭
 * @author Java男朋友
 * @date 2021-10-29 8:11
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlayWithWings();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("我是可达鸭");
    }


}
