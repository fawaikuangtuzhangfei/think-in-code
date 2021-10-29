package com.think.design.strategy.abstractstrategy.impl;

import com.think.design.strategy.abstractstrategy.FlyBehavior;

/**
 * 具体策略类
 * 火箭飞
 * @author Java男朋友
 * @date 2021-10-29 8:15
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("火箭飞咯.....");
    }
}
