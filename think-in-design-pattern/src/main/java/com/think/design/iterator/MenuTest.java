package com.think.design.iterator;

import com.think.design.iterator.aggregate.Menu;
import com.think.design.iterator.aggregate.concreteaggregate.CafeMenu;
import com.think.design.iterator.aggregate.concreteaggregate.DinerMenu;
import com.think.design.iterator.aggregate.concreteaggregate.PancakeHouseMenu;
import com.think.design.iterator.base.Waitress;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Java男朋友
 * @date 2022-01-12 7:54
 */
public class MenuTest {

    public static void main(String[] args) {
        Menu pancakeHouseMenu = new PancakeHouseMenu();
        Menu dinerMenu = new DinerMenu();
        Menu cafeMenu = new CafeMenu();
        List<Menu> menus = new ArrayList<>();
        menus.add(pancakeHouseMenu);
        menus.add(cafeMenu);
        menus.add(dinerMenu);
        Waitress waitress = new Waitress(menus);
        waitress.printMenu();
    }
}
