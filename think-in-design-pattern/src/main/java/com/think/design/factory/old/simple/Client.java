package com.think.design.factory.old.simple;

/**
 * @author yc
 * @description
 * @date 2021-09-23 11:36
 */
class Client {
    public static void main(String args[]) {
        Product product;
        //通过工厂类创建产品对象
        product = Factory.getProduct("A");
        product.methodSame();
        product.methodDiff();
    }
}
