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
                .peek(s -> System.out.println(Thread.currentThread().getName() + " peek1:" + s))
                // 无状态操作
                .filter(s -> {
                    System.out.println(Thread.currentThread().getName()  + " filter:" + s);
                    return true;
                })
                // 有状态操作
                .sorted((i1, i2) ->{
                    System.out.println(Thread.currentThread().getName()  + " 排序:" + i1 + "," + i2);
                    return i1.compareTo(i2);
                })
                // 无状态操作
                .peek(s -> System.out.println(Thread.currentThread().getName() + " peek2:" + s))
                .peek(s -> System.out.println(Thread.currentThread().getName() + " peek3:" + s))
                // 并行
                .parallel()
                // 无状态操作
                .peek(s -> System.out.println(Thread.currentThread().getName() + " peek4:" + s))
                .filter(s -> {
                    System.out.println(Thread.currentThread().getName()  + " filter2:" + s);
                    return true;
                })
                // 有状态操作
                .sorted((i1, i2) ->{
                    System.out.println(Thread.currentThread().getName()  + " 排序2:" + i1 + "," + i2);
                    return i1.compareTo(i2);
                })
                ;
        integerStream.count();

    }
}
