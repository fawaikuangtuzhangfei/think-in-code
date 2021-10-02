package com.fun.refrence;

import com.fun.bean.User;

import java.lang.ref.WeakReference;

/**
 * @author Java男朋友
 * @date 2021-09-08 7:55
 */
public class WeekReferenceDemo {

    public static void main(String[] args) {

        User o1 = new User();
        WeakReference<Object> weakReference = new WeakReference<Object>(o1);

        System.out.println(o1);
        System.out.println(weakReference.get());

        System.out.println("=============");

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
