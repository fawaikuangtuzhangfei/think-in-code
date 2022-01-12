package com.think.design.iterator;

import com.think.design.iterator.base.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * lou 的菜单迭代器
 * @author Java男朋友
 * @date 2022-01-12 7:45
 */
public class PancakeHouseMenuIterator implements Iterator {

    private ArrayList<MenuItem> menuItems;

    private Integer position;

    public PancakeHouseMenuIterator(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
        position = 0;
    }

    @Override
    public boolean hasNext() {
        if(menuItems.size() > position){
            return true;
        }
        return false;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menuItems.get(position);
        position = position + 1;
        return menuItem;
    }
}
