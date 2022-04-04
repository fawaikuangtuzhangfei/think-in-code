package com.think.design.component.iterators;

import java.util.Iterator;

/**
 * @author Java男朋友
 * @date 2022-03-02 21:53
 */
public class NullIterator implements Iterator {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
