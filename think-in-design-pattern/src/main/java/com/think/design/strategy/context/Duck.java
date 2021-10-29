package com.think.design.strategy.context;

import com.think.design.strategy.abstractstrategy.FlyBehavior;
import com.think.design.strategy.abstractstrategy.QuackBehavior;

/**
 * 鸭子类-环境类
 *  一个外观
 *  两个行为：飞和叫
 * @author Java男朋友
 * @date 2021-10-29 8:05
 */
public abstract class Duck {

    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
