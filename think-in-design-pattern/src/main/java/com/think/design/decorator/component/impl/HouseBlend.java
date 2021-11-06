package com.think.design.decorator.component.impl;

import com.think.design.decorator.component.Beverage;

/**
 * 混合咖啡-具体组件
 * @author Java男朋友
 * @date 2021-11-03 22:28
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        this.description = "House Blend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
