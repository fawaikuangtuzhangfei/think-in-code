package com.fun.sof;

/**
 * HotSpot 栈容量不足造成SOF
 * VM Args：-Xss128k
 * 测试结果：stack length:983
 *
 * VM Args：-Xss640k
 * 测试结果：stack length:11223
 *
 * Exception in thread "main" java.lang.StackOverflowError
 *
 * -Xss 每个线程栈的大小
 *
 * @author Java男朋友
 * @date 2021-08-29 16:13
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
