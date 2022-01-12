package com.think.design.iterator.base;

import com.think.design.iterator.DinerMenuIterator;

import java.util.Iterator;

/**
 * diner 的菜单
 * @author Java男朋友
 * @date 2022-01-12 8:01
 */
public class DinerMenu {

    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;		//使用一个数组，所以可以控制菜单的长度，并且在取出菜单项的时候，不需要转型


    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on Whole wheat", true,
                2.99);

        addItem("BLT", "Bacon with lettuce & tomato on Whole wheat", false,
                2.99);

        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad", false, 3.29);

        addItem("Hotdog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false, 3.05);

        addItem("Steamed Veggies and Brown Rice",
                "Steamed vegetables over brown rice", true, 3.99);
        addItem("Pasta",
                "Spaghetti with Marinara Sauce, and a slice of sourdough bread",
                true, 3.89);
    }



    private void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if(numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }



    /**
     * 增加了迭代器之后，这个方法就不需要了
     * @return
     */
	/*public MenuItem[] getMenuItems() {
		return menuItems;
	}*/


    /**
     * 用来从菜单项数组创建一个DinerMenuIterator,并将它返回给客户
     */
    public Iterator createIterator() {
        return new DinerMenuIterator(menuItems);
    }

}
