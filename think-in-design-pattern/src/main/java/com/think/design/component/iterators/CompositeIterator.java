package com.think.design.component.iterators;

import com.think.design.component.component.MenuComponent;
import com.think.design.component.component.impl.Menu;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author Java男朋友
 * @date 2022-03-02 21:26
 */
public class CompositeIterator implements Iterator {

    private Stack<Iterator> stack = new Stack<>();

    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if(stack.empty()){
            return false;
        }else{
            Iterator peek = stack.peek();
            if(peek.hasNext()){
                return true;
            }else{
                stack.pop();
                return hasNext();
            }
        }
    }

    @Override
    public Object next() {
        if(hasNext()){
            Iterator peek = stack.peek();
            MenuComponent next = (MenuComponent) peek.next();
            if (next instanceof Menu) {
                stack.push(next.createIterator());
            }
            return next;
        }else{
            return null;
        }
    }
}
