package com.think.design.strategy.abstractstrategy.impl;

import com.think.design.strategy.abstractstrategy.FlyBehavior;

/**
 * 具体策略类
 * 普通飞
 * @author Java男朋友
 * @date 2021-10-29 8:17
 */
public class FlayWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i am fly");
    }
}
