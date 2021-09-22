package com.fun.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/**
 * 通过反射，利用Unsafe类去申请内存
 * VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * ps: 但是这个参数设置了没啥效果？不解
 *
 * Exception in thread "main" java.lang.OutOfMemoryError
 * 	at sun.misc.Unsafe.allocateMemory(Native Method)
 * 	at com.fun.oom.DirectMemoryOOM.main(DirectMemoryOOM.java:23)
 *
 * @author Java男朋友
 * @date 2021-08-31 6:20
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        for (int j = 0; j < 3000; j++) {
            unsafe.allocateMemory(_1MB);
        }
//        int i = 0;
//        while (true) {
//            System.out.println(i++);
//            unsafe.allocateMemory(_1MB);
//        }
    }
}
