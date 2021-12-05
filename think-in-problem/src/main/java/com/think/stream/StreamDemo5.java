package com.think.stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 并行流
 * 默认使用的是JDK的 ForkJoinPool 默认是当前机器的核数（cpu）
 * @author Java男朋友
 * @date 2021-12-05 14:23
 */
public class StreamDemo5 {

    public static void main(String[] args) throws InterruptedException {
        // 并行流
        IntStream.range(1, 100).parallel().peek(StreamDemo5::debug).count();

        // 多次调用并行和串行流，以最后一次调用为准
        IntStream.range(1, 100)
        // 先并行流
        .parallel().peek(StreamDemo5::debug)
        // 后串行流
        .sequential().peek(StreamDemo5::debug2)
        .count();

        // 使用自己的线程池，防止任务被阻塞
        // 线程的名字
        ForkJoinPool pool = new ForkJoinPool(20);
        pool.submit(() -> IntStream.range(1, 100).parallel().peek(StreamDemo5::debug).count());
        pool.shutdown();

        synchronized (pool){
            pool.wait();
        }
    }

    public static void debug(int i){
        System.out.println(Thread.currentThread().getName() + " debug: " + i);
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public static void debug2(int i){
        System.err.println("debug: " + i);
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
