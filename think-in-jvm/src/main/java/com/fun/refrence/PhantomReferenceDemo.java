package com.fun.refrence;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用
 * @author Java男朋友
 * @date 2021-09-08 8:18
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) {
        ReferenceQueue queue = new ReferenceQueue();
        Object obj = new Object();
        PhantomReference<Object> phantomReference = new PhantomReference<>(obj, queue);

        System.out.println(phantomReference.get());
        System.out.println(obj);
        System.out.println(queue.poll());

        System.out.println("=================");

        obj = null;
        System.gc();
        System.out.println(phantomReference.get());
        System.out.println(obj);
        System.out.println(queue.poll());
    }
}
