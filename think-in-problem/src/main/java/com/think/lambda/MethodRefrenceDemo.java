package com.think.lambda;

import java.util.function.*;

/**
 * 方法引用
 * ps:分析输入和输出是什么来决定使用哪个函数式接口
 * @author Java男朋友
 * @date 2021-12-04 16:58
 */
public class MethodRefrenceDemo {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat(1);

        // 方法引用  Consumer<String> consumer2 = str -> System.out.println(str);
        Consumer<String> consumer = System.out::println;
        consumer.accept("接收的数据");

        // 静态方法的方法引用
        Consumer<Dog> dogConsumer = Dog::bark;
        dogConsumer.accept(dog);

        // 非静态方法，使用对象实例引用
        IntUnaryOperator unaryOperator = dog::eat;
        System.out.println("还剩: " + unaryOperator.applyAsInt(2) + "斤狗粮");

        // 非静态方法 使用类名来使用方法引用
        BiFunction<Dog, Integer, Integer> eatFunction = Dog::eat;
        System.out.println("还剩: " + eatFunction.apply(dog, 3));

        // 构造函数的方法引用 -无参的
        Supplier<Dog> dogSupplier = Dog::new;
        System.out.println("新对象还剩:" + dogSupplier.get().eat(3) + "斤狗粮");

        // 有参的
        Function<String, Dog> function = Dog::new;
        System.out.println(function.apply("雷霆犬").eat(3));
    }
}

class Dog{

    private String name = "哮天犬";

    private int food = 10;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public static void bark(Dog dog){
        System.out.println(dog + "叫了");
    }

    /**
     * JDK 默认会将当前实例传入到非静态方法，参数名为this，位置是第一个,所以在非静态方法里也可以使用this.
     * @param num
     * @return
     */
    public int eat(Dog this, int num){
        System.out.println(this + "吃了:" + num + "斤狗粮");
        this.food = food - num;
        return food;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
