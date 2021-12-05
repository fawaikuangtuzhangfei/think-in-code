package com.think.lambda;

/**
 * 类型推断
 * @author Java男朋友
 * @date 2021-12-04 18:29
 */
public class TypeDemo {
    public static void main(String[] args) {
        // 手动类型标识
        IMath lambda3 = (int x, int y) -> x + y;

        // ---------------------自动类型推断------------------------
        // 变量类型定义
        IMath lambda = (x,y) -> x + y;

        // 数组里
        IMath[] lambdas = {(x,y) -> x + y};

        // 强转
        Object lambda2 = (IMath) (x,y) -> x + y;

        // 通过返回类型
        IMath ceateLambda = ceateLambda();

        TypeDemo typeDemo = new TypeDemo();
        // 当存在二义性，使用强转对应的接口解决
        typeDemo.test((IMath2)(x,y) -> x + y);
    }

    public static IMath ceateLambda(){
        return (x,y) -> x + y;
    }

    public void test(IMath iMath){

    }

    public void test(IMath2 iMath){

    }
}

@FunctionalInterface
interface IMath{
    int add(int x, int y);
}


@FunctionalInterface
interface IMath2{
    int add(int x, int y);
}

