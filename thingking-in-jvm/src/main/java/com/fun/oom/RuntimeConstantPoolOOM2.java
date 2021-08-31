package com.fun.oom;

/**
 * intern测试
 *      常量池中存在就拿，不存在就添加
 * @author Java男朋友
 * @date 2021-08-29 20:37
 */
public class RuntimeConstantPoolOOM2 {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        // true 字符串常量池中的就是当前字符串
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        // false java属于内置关键字，字符串常量池中已经存在了，和此刻new 的肯定不一样
        System.out.println(str2.intern() == str2);
    }
}

