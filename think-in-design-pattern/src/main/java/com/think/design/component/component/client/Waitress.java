package com.think.design.component.component.client;

import com.think.design.component.component.MenuComponent;
import com.think.design.iterator.aggregate.Menu;
import com.think.design.iterator.base.MenuItem;

import java.util.Iterator;
import java.util.List;

/**
 * 女招待
 * @author Java男朋友
 * @date 2022-02-23 18:44
 */
public class Waitress {

    private MenuComponent menus;


    public Waitress(MenuComponent menuComponent) {
        this.menus = menuComponent;
    }

    public void printMenu(){
        System.out.println("test");
        menus.print();
    }

    public void printVegetarian(){
        System.out.println("mt");
    }


}
