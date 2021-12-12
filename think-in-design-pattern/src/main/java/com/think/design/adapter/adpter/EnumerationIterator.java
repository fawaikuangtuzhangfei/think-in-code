package com.think.design.adapter.adpter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 适配器
 *  Iterator 适配成 Enumeration
 * @author Java男朋友
 * @date 2021-11-22 7:58
 */
public class EnumerationIterator implements Enumeration {

    private Iterator iterator;

    public EnumerationIterator(Iterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return iterator.next();
    }

    public void remove(){
        iterator.remove();
    }
}
