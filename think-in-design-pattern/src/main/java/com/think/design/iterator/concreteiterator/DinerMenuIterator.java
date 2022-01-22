package com.think.design.iterator.concreteiterator;

import com.think.design.iterator.base.MenuItem;

import java.util.Iterator;

/**
 * @author Java男朋友
 * @date 2022-01-12 8:02
 */
public class DinerMenuIterator implements Iterator {

    private MenuItem[] menuItems;

    private Integer position;

    public DinerMenuIterator(MenuItem[] menuItems) {
        position = 0;
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if(menuItems.length > position){
            return true;
        }
        return false;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menuItems[position];
        position += 1;
        return menuItem;
    }

    @Override
    public void remove() {
        if(position <= 0){
            throw new IllegalStateException("at least one next()");
        }
        if(menuItems[position - 1] != null){
            for(int i = position - 1; i < menuItems.length -1 ; i++){
                menuItems[i] = menuItems[i+1];
            }
            menuItems[menuItems.length - 1] = null;
        }
    }
}
