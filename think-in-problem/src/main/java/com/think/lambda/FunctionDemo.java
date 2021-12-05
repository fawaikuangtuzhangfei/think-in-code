package com.think.lambda;

import java.util.function.*;

/**
 * 常见的函数接口
 * @author Java男朋友
 * @date 2021-12-04 16:29
 */
public class FunctionDemo {

    public static void main(String[] args) {

        // 断言函数式接口
        Predicate<Integer> predicate = i -> i>1;
        System.out.println(predicate.test(9));
        System.out.println(predicate.test(-9));

        // 自带类型的断言函数式接口 ---> 优先使用自带的函数式接口，这样可以免去泛型
        IntPredicate intPredicate = i -> i>1;
        System.out.println(intPredicate.test(0));

        //消费函数接口   IntConsumer
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("消费函数接口");

        // 一个输入 一个输出 IntFunction
        Function<Integer, String> function = i -> "double的结果:" + i * 2;
        System.out.println(function.apply(3));

        // 供给型函数接口
        IntSupplier intSupplier = () -> 10086;
        System.out.println(intSupplier.getAsInt());

        // 一元函数 求圆的面积
        DoubleUnaryOperator unaryOperator = r -> 3.14 * 2 * r;
        System.out.println("圆的面积:" + unaryOperator.applyAsDouble(5));

        // 两个输入的函数
        BiFunction<Integer, Integer, String> biFunction = (i, j) -> "两数字相乘:" + i*j;
        System.out.println(biFunction.apply(1, 2));

        // 二元函数 输入输出类型相同
        DoubleBinaryOperator binaryOperator = (i, j) -> i*j;
        System.out.println(binaryOperator.applyAsDouble(3.14, 2));

    }
}
