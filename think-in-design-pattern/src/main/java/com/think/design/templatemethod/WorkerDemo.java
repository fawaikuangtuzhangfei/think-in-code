package com.think.design.templatemethod;

import com.think.design.templatemethod.concrete.DumplingFood;
import com.think.design.templatemethod.concrete.InstantNoodles;

/**
 * 测试模板方法
 * @author Java男朋友
 * @date 2021-12-21 21:44
 */
public class WorkerDemo {

    public static void main(String[] args) {
        DumplingFood dumplingFood = new DumplingFood();
        dumplingFood.prepare();
        System.out.println("-------------------");
        InstantNoodles instantNoodles = new InstantNoodles();
        instantNoodles.prepare();
    }
}
