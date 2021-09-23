package com.think.design.factory.simple;

/**
 * @author yc
 * @description
 * @date 2021-09-23 11:34
 */
abstract class Product {

    /**
     * 所有产品类的公共业务方法
     */
    public void methodSame() {
        //公共方法的实现
    }

    /**
     * 声明抽象业务方法
     */
    public abstract void methodDiff();
}

