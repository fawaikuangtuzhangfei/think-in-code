package com.think.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流的创建
 * @author Java男朋友
 * @date 2021-12-05 9:20
 */
public class StreamDemo2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 从集合创建
        list.stream();
        // 并行流
        list.parallelStream();

        // 从数组创建
        Arrays.stream(new int[]{2,3,5});

        // 创建数字流
        IntStream.of(1,2,3);
        IntStream.rangeClosed(1, 10);

        // 使用Random创建一个无限流
        Random random = new Random();
        random.ints().limit(10);

        // 自己产生流
        Stream.generate(() -> random.nextInt()).limit(20);
    }
}
