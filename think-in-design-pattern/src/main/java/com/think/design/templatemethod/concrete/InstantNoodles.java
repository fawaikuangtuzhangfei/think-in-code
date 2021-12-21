package com.think.design.templatemethod.concrete;

import com.think.design.templatemethod.abstractmethod.FastFood;

/**
 * 具体操作
 * 方便面
 * @author Java男朋友
 * @date 2021-12-21 21:43
 */
public class InstantNoodles extends FastFood {
    @Override
    public void pourIntoPot() {
        System.out.println("下面，再加两颗鸡蛋");
    }

    @Override
    public void eat() {
        System.out.println("放调料，开吃");
    }
}
