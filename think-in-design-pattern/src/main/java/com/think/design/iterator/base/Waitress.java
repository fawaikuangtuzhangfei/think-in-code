package com.think.design.iterator.base;

import com.think.design.iterator.aggregate.concreteaggregate.CafeMenu;
import com.think.design.iterator.base.MenuItem;
import com.think.design.iterator.aggregate.Menu;

import java.util.Iterator;
import java.util.List;

/**
 * 女招待
 * 1.菜单的打印
 * @author Java男朋友
 * @date 2022-01-12 7:49
 */
public class Waitress {

    private List<Menu> menus;


    public Waitress(List<Menu> menus) {
        this.menus = menus;
    }

    public void printMenu(){
        for (Menu menu : menus) {
            printMenu(menu.createIterator());
        }
    }

    public void printMenu(Iterator iterator){
        while (iterator.hasNext()){
            MenuItem next = (MenuItem) iterator.next();
            System.out.println(next);
        }
    }
}
