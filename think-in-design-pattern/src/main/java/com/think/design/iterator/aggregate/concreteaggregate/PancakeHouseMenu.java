package com.think.design.iterator.aggregate.concreteaggregate;

import com.think.design.iterator.aggregate.Menu;
import com.think.design.iterator.base.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * lou 的菜单
 * @author Java男朋友
 * @date 2022-01-12 7:43
 */
public class PancakeHouseMenu implements Menu {

    ArrayList menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList();

        addItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);

        addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);

        addItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49);

        addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);

    }

    /**
     * 创建一个新的菜单项对象，传入每一个变量，然后将它加入到ArrayList中
     * @param name	菜名
     * @param description 叙述
     * @param vegetarian  是否为素食
     * @param price	价格
     */
    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }


    @Override
    public Iterator createIterator() {
        return menuItems.iterator();
    }

}
