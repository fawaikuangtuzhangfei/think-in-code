package com.think.design.iterator;

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
}
