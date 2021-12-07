package com.think.lambda;

/**
 * 测试 lambda
 * @author Java男朋友
 * @date 2021-12-04 10:46
 */
public class LambdaDemo {

    public static void main(String[] args) {
        MyInterface num1 = i -> {
            MyInterface.sum(1,3);
//            add(1); lamda表达式不能像匿名内部类一样调用默认实现的方法
            return i*2;
        };
        MyInterface myInterface = new MyInterface(){

            @Override
            public int doubleNum(int i) {
                add(1);
                MyInterface.sum(1,2);
                return 0;
            }
        };
    }
}

@FunctionalInterface
interface MyInterface {
    int doubleNum(int i);

    default void add(int i){
        System.out.println("可以有默认的方法,但是必须只存在一个接口");
    }

//    int doubleNum2(int i); 会报错，@FunctionalInterface标注后，只能存在一个

    static void sum(int x, int y){

    }

    @Override
    boolean equals(Object obj);
}

@FunctionalInterface
interface MyInterface2 {
    int doubleNum(int i);

    default void add(int i, int j){
        System.out.println("可以有默认的方法,但是必须只存在一个接口");
    }
}

@FunctionalInterface
interface MyInterface3 extends MyInterface, MyInterface2 {

    @Override
    default void add(int i) {
        System.out.println("default 方法必须实现");
    }
}