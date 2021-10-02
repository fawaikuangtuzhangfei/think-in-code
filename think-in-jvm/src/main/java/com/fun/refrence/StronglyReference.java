package com.fun.refrence;

import com.fun.bean.User;

/**
 * @author Java男朋友
 * @date 2021-09-08 8:12
 */
public class StronglyReference {

    public static void main(String[] args) {
        User u1 = new User();
        User u2 = u1;
        u1 = null;
        System.gc();
        System.out.println(u2);
    }
}
