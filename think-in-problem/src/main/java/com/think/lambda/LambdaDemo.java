package com.think.lambda;

/**
 * 测试 lambda
 * @author Java男朋友
 * @date 2021-12-04 10:46
 */
public class LambdaDemo {

    public static void main(String[] args) {
        Interface1 num1 = i -> i*2;
    }
}

@FunctionalInterface
interface Interface1{
    int doubleNum(int i);

    default void add(int i){
        System.out.println("可以有默认的方法,但是必须只存在一个接口");
    }

//    int doubleNum2(int i); 会报错，@FunctionalInterface标注后，只能存在一个
}

@FunctionalInterface
interface Interface2{
    int doubleNum(int i);

    default void add(int i, int j){
        System.out.println("可以有默认的方法,但是必须只存在一个接口");
    }
}

@FunctionalInterface
interface Interface3 extends Interface1, Interface2{

    @Override
    default void add(int i) {
        System.out.println("default 方法必须实现");
    }
}