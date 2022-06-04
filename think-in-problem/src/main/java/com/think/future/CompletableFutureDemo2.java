package com.think.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author yc
 * @description
 * @date 2021-10-25 18:21
 */
public class CompletableFutureDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " do");
            int i = 10 / 2;
            System.out.println(Thread.currentThread().getName() + " do " + i);
            return i;
        }).thenApplyAsync((result)->{
            System.out.println(Thread.currentThread().getName() + " thenApplyAsync " + result);
            return "hello" + result;
        }).thenAcceptAsync(res->{
            System.out.println(Thread.currentThread().getName() + " do thenAcceptAsync" + res);
            return;
        }).thenRunAsync(()->{
            System.out.println(Thread.currentThread().getName() + " do thenRunAsync");
        });
        System.out.println("线程end..." + future.get());
    }
}
