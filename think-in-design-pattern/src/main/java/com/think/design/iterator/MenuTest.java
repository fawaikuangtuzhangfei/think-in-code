package com.think.design.iterator;

import com.think.design.iterator.aggregate.concreteaggregate.CafeMenu;
import com.think.design.iterator.aggregate.concreteaggregate.DinerMenu;
import com.think.design.iterator.aggregate.concreteaggregate.PancakeHouseMenu;
import com.think.design.iterator.base.Waitress;

/**
 * @author Java男朋友
 * @date 2022-01-12 7:54
 */
public class MenuTest {

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        CafeMenu cafeMenu = new CafeMenu();
        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, cafeMenu);
        waitress.printMenu();
    }
}
