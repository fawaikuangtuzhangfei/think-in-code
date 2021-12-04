package com.think.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author yc
 * @description CompletableFuture测试
 * @date 2021-10-22 17:27
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, Exception {
        AtomicInteger num = new AtomicInteger(0);
        CompletableFuture<List<Long>> roleListFuture = CompletableFuture.supplyAsync(() -> {
//            int i = 1/0;
            num.getAndIncrement();
            stopTime();
            return new ArrayList<>();
        });
        CompletableFuture<Void> v1 = roleListFuture.thenAcceptAsync(list -> {
            System.out.println(Thread.currentThread().getName());
            num.getAndIncrement();
            stopTime();
//            int i = 1 / 0;
        });
        CompletableFuture<Void> v2 = roleListFuture.thenAcceptAsync(list -> {
            System.out.println("v2正在执行ing:"  + Thread.currentThread().getName());
            num.getAndIncrement();
        });
        roleListFuture.thenAccept(list -> {
            System.out.println("thenAccept 正在执行ing:" + Thread.currentThread().getName());
            num.getAndIncrement();
            stopTime();
            throw new RuntimeException();
        }).exceptionally(e -> {
            System.out.println("zese");
            return null;
        });


        CompletableFuture<Void> voidCompletableFuture = roleListFuture.thenAccept(list -> {
            System.out.println("thenAccept2 正在执行ing：" + Thread.currentThread().getName());
            num.getAndIncrement();
            throw new RuntimeException();
        });

        System.out.println("不阻塞当前main线程");

//        CompletableFuture.allOf(roleListFuture).exceptionally(e -> {
//            System.out.println("异常v" + num + e);
//            System.out.println(Thread.currentThread().getName());
//            return null;
//        }).get();
//        CompletableFuture.allOf(v1, v2).get();
//        CompletableFuture.allOf(voidCompletableFuture).get();
//        CompletableFuture.allOf(v1, v2).exceptionally(e -> {
//            System.out.println("异常vv" + num + e );
//            return null;
//        }).get();
    }

    private static void stopTime() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
