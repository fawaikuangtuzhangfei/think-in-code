package com.fun.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * HotSpot 堆内存溢出造成OOM
 * -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
 *      -XX:+HeapDumpOnOutOfMemoryError 让虚拟机在出现内存溢出异常时Dump出当前内存堆转快照
 *
 * @author Java男朋友
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
