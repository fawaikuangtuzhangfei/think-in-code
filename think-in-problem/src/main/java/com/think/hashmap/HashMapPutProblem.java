package com.think.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yc
 * @description 并发情况下 HashMap 会存在线程安全问题
 * @date 2021-10-12 10:40
 */
public class HashMapPutProblem extends Thread{
    static HashMap<Integer, Integer> map = new HashMap<>();
    static Map<Integer, Integer> con = new ConcurrentHashMap<>();
    static AtomicInteger aInteger=new AtomicInteger();

    @Override
    public void run() {
        while (aInteger.get() < 1000) {
            con.put(aInteger.get(), aInteger.get());
            con.remove(aInteger.get(), aInteger.get());
            System.out.println(Thread.currentThread().getName() + "插入数据为:" + aInteger + "     此时容量为: " + map.size());
            aInteger.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        HashMapPutProblem t=new HashMapPutProblem();
        t.start();
        Thread[] threads=new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i]=new Thread(t,"线程"+i);
            threads[i].start();
        }
    }
}

