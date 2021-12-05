package com.think.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 中间操作
 * @author Java男朋友
 * @date 2021-12-05 9:30
 */
public class StreamDemo3 {

    public static void main(String[] args) {
        String str = "my name is 007";

        // 把单词长度大于2的单词的长度打印出来
        Stream.of(str.split(" "))
                .filter(s -> s.length()>2).map(s -> s.length()).forEach(System.out::println);

        // flatMap A->B属性(是个集合),最终得到所有A元素里面的所有B属性集合
        // IntStream并不是Stream的子类，所以要进行装箱 boxed
        Stream.of(str.split(" ")).flatMap(s -> s.chars().boxed())
                .forEach(i -> System.out.println((char)i.intValue()));

        Stream.of(str.split(" ")).map(CharSequence::chars)
                .forEach(s -> s.forEach(u -> System.out.println((char)u)));

        // peek用于debug，是个中间操作， foreach是终止操作
        System.out.println("--------------------peek--------------------");
        Stream.of(str.split(" ")).peek(System.out::println).forEach(System.out::println);

        // limit 主要用于无限流
        new Random().ints().filter(i -> i > 100 && i < 1000).limit(10).forEach(System.out::println);
    }
}
