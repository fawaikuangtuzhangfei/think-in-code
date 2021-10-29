package com.think.design.strategy.abstractstrategy.impl;

import com.think.design.strategy.abstractstrategy.QuackBehavior;

/**
 * @author Java男朋友
 * @date 2021-10-29 8:19
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack quck");
    }
}
