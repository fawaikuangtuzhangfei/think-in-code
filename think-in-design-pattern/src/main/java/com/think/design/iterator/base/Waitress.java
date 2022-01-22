package com.think.design.iterator.base;

import com.think.design.iterator.base.MenuItem;
import com.think.design.iterator.aggregate.Menu;

import java.util.Iterator;

/**
 * 女招待
 * 1.菜单的打印
 * @author Java男朋友
 * @date 2022-01-12 7:49
 */
public class Waitress {

    private Menu pancakeHouseMenu;

    private Menu dinerMenu;

    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu(){
        Iterator iterator = pancakeHouseMenu.createIterator();
        Iterator dinerMenuIterator = dinerMenu.createIterator();
        printMenu(iterator);
        printMenu(dinerMenuIterator);
    }

    public void printMenu(Iterator iterator){
        while (iterator.hasNext()){
            MenuItem next = (MenuItem) iterator.next();
            System.out.println(next);
        }
    }
}
