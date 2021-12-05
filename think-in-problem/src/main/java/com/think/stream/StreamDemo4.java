package com.think.stream;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 终止操作
 * @author Java男朋友
 * @date 2021-12-05 10:58
 */
public class StreamDemo4 {

    public static void main(String[] args) {
        String str = "my name is 007";

        // 并行流
        str.chars().parallel().forEach(i -> System.out.print((char)i));

        System.out.println("-----------------------------");
        // 保证顺序 forEachOrdered
        str.chars().parallel().forEachOrdered(i -> System.out.print((char)i));

        // 收集到list
        List<String> stringList = Stream.of(str.split(" ")).collect(Collectors.toList());
        System.out.println(stringList);

        // reduce 拼接字符串
        Optional<String> letters = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "-" + s2);
        System.out.println(letters.orElse(""));

        // 带初始值的reduce
        String reduce = Stream.of(str.split(" ")).reduce("", (s1, s2) -> s1 + "-" + s2);
        System.out.println(reduce);

        // 计算所有单词总长度
        Integer reduce1 = Stream.of(str.split(" ")).map(s -> s.length()).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(reduce1);

        // max
        Optional<String> max = Stream.of(str.split(" ")).max((s1, s2) -> s1.length() - s2.length());
        System.out.println("最大值:" + max.get());

        // 短路操作
        OptionalInt first = new Random().ints().findFirst();
        System.out.println(first.getAsInt());

    }
}
