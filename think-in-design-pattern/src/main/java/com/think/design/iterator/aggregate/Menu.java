package com.think.design.iterator.aggregate;

import java.util.Iterator;

/**
 * 面向接口编程，减少 Waitress 和具体类的耦合
 * @author Java男朋友
 * @date 2022-01-15 18:33
 */
public interface Menu {

    /**
     * 创建一个迭代器
     * @return 迭代器
     */
    Iterator createIterator();

}
