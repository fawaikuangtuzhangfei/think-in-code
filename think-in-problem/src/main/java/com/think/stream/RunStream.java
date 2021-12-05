package com.think.stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 * Stream 运行机制
 * @author Java男朋友
 * @date 2021-12-05 17:36
 */
public class RunStream {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Stream<Integer> integerStream = Stream.generate(() -> random.nextInt())

                .limit(5)
                // 无状态操作
                .peek(System.out::println)
                // 无状态操作
                .filter(s -> {
                    System.out.println("filter:" + s);
                    return s > 100000;
                })
                // 有状态操作
                .sorted((i1, i2) ->{
                    System.out.println("排序:" + i1 + "," + i2);
                    return i1.compareTo(i2);
                })
                // 无状态操作
                .peek(s -> System.out.println("peek2:" + s))
                // 并行
                .parallel()
                ;
        integerStream.count();

    }
}
