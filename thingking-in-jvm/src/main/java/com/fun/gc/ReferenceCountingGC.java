package com.fun.gc;

/**
 * -XX:+PrintGCDetails
 * 结果：发生了GC
 * [GC (System.gc()) [PSYoungGen: 10497K->808K(74240K)] 10497K->816K(243712K), 0.0009477 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * @author Java男朋友
 * @date 2021-09-07 8:01
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    /**
     * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否有回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];
    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        // 假设在这行发生GC，objA和objB是否能被回收？
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
