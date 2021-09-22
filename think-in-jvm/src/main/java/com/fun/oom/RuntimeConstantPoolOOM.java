package com.fun.oom;

import java.util.HashSet;
import java.util.Set;

/**
 * 运行时常量池导致的内存溢出异常
 * 运行时常量池在永久代里存放着，降低永久代的大小=降低运行时常量池大小
 * jdk1.6
 * VM Args：-XX:PermSize=6M -XX:MaxPermSize=6M
 *
 * jdk1.7
 * VM Args：-XX:PermSize=6M -XX:MaxPermSize=6M
 * 不会出现OOM
 *
 * jdk1.8
 * -XX:MaxMetaspaceSize=12m
 * 不会出现 OOM
 * -Xms6m 出现OOM
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * 	at java.util.HashMap.resize(HashMap.java:704)
 *
 * 原因：
 *  自JDK 7起，原本存放在永久代的字符串常量池被移至Java堆之中
 *
 * @author Java男朋友
 * @date 2021-08-29 19:52
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        // 使用Set保持着常量池引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<String>();
        // 在short范围内足以让6MB的PermSize产生OOM了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
