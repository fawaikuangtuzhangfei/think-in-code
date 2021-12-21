package com.think.design.templatemethod.abstractmethod;

/**
 * 抽象方法-算法框架
 * 快速食品
 * 比如速食饺子、速食混沌、方便面
 * @author Java男朋友
 * @date 2021-12-21 21:35
 */
public abstract class FastFood {

    public final void prepare(){
        boil();
        pourIntoPot();
        takeOut();
        eat();
        end();
    }

    public void boil(){
        System.out.println("boil water...");
    }

    /**
     * 将速食食品下锅
     */
    public abstract void pourIntoPot();

    /**
     * 捞出来
     */

    public void takeOut(){
        System.out.println("take it out...");
    }

    public abstract void eat();

    /**
     * 钩子方法，可以用来实现后置处理操作，比如洗碗、或者啥也不做
     */
    public void end(){}
}
