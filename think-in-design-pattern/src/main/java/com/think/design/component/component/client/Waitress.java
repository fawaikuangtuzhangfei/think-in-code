package com.think.design.component.component.client;

import com.think.design.component.component.MenuComponent;

import java.util.Iterator;

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
        menus.print();
    }

    public void printVegetarian(){
        Iterator<MenuComponent> iterator = menus.createIterator();
        while (iterator.hasNext()) {
            try {
                MenuComponent next = iterator.next();
                if (next.isVegetarian()){
                    next.print();
                }
            } catch (Exception e) {
            }
        }
    }


}
