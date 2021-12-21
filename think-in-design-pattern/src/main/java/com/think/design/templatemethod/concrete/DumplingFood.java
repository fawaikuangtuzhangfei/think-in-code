package com.think.design.templatemethod.concrete;

import com.think.design.templatemethod.abstractmethod.FastFood;

/**
 * 具体操作
 * 速食水饺
 * @author Java男朋友
 * @date 2021-12-21 21:41
 */
public class DumplingFood extends FastFood {
    @Override
    public void pourIntoPot() {
        System.out.println("直接下锅...");
    }

    @Override
    public void eat() {
        System.out.println("今天冬至,倒醋吃水饺");
    }

    @Override
    public void end() {
        System.out.println("吃完刷刷锅呗");
    }
}
