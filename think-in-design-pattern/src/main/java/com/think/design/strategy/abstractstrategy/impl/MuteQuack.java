package com.think.design.strategy.abstractstrategy.impl;

import com.think.design.strategy.abstractstrategy.QuackBehavior;

/**
 * @author Java男朋友
 * @date 2021-10-29 8:20
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("mute mute");
    }
}
