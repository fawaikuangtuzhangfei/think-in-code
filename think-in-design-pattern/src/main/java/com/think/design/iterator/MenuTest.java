package com.think.design.iterator;

import com.think.design.iterator.base.DinerMenu;
import com.think.design.iterator.base.PancakeHouseMenu;

/**
 * @author Java男朋友
 * @date 2022-01-12 7:54
 */
public class MenuTest {

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
    }
}
