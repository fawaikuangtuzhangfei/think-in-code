package com.think.design.strategy;

import com.think.design.strategy.abstractstrategy.impl.FlyRocketPowered;
import com.think.design.strategy.context.Duck;
import com.think.design.strategy.context.impl.CommonDuck;

/**
 * 策略模式
 * @author Java男朋友
 * @date 2021-10-29 8:10
 */
public class StrategyMain {

    public static void main(String[] args) {
        Duck duck = new CommonDuck();
        duck.performFly();
        duck.display();
        System.out.println("增加火箭装置....");
        duck.setFlyBehavior(new FlyRocketPowered());
        duck.performFly();
    }
}
