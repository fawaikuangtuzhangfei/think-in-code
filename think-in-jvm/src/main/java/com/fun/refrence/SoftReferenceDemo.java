package com.fun.refrence;

import java.lang.ref.SoftReference;

/**
 * 软引用
 * -Xmx10m
 * @author Java男朋友
 * @date 2021-09-08 8:23
 */
public class SoftReferenceDemo {

    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        Object obj = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj);

        System.out.println(softReference.get());
        System.out.println(obj);

        obj = null;
        System.out.println("=========产生大对象,内存够用===========");
        try {
            byte[] bytes = new byte[5 * _1MB];
        } catch (Exception e) {


        } finally {
            System.out.println(obj);
            System.out.println(softReference.get());
        }

        System.out.println("=========产生大对象,内存不够用===========");
        try {
            byte[] bytes = new byte[10 * _1MB];
        } catch (Exception e) {


        } finally {
            System.out.println(obj);
            System.out.println(softReference.get());
        }
    }
}
