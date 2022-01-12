package com.think.design.iterator;

import com.think.design.iterator.base.DinerMenu;
import com.think.design.iterator.base.MenuItem;
import com.think.design.iterator.base.PancakeHouseMenu;

import java.util.Iterator;

/**
 * 女招待
 * 1.菜单的打印
 * @author Java男朋友
 * @date 2022-01-12 7:49
 */
public class Waitress {

    private PancakeHouseMenu pancakeHouseMenu;

    private DinerMenu dinerMenu;

    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
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
