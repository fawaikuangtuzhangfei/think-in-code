package com.think.lambda;

import java.text.DecimalFormat;
import java.util.function.Function;

/**
 * 测试Lambda
 * @author Java男朋友
 * @date 2021-12-04 11:10
 */
public class MoneyDemo {
    public static void main(String[] args) {
        MyMoney me = new MyMoney(99999999);
        Function<Integer, String> moneyFormat = i -> new DecimalFormat("#, ####").format(i);
        me.printMoney(moneyFormat.andThen(s -> "人民币 " + s));

        Runnable runnable = () -> System.out.println("lambda");

        Runnable thread = new Runnable() {
            @Override
            public void run() {
                System.out.println("创建一个线程");
            }
        };
    }
}
/**
 * jdk8 以后的方式
 */
class MyMoney{
    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }

    public void printMoney(Function<Integer, String> moneyFormat){
        System.out.println("我的存款:" + moneyFormat.apply(this.money));
    }
}

/**
 * 以前的方式
 */
/*interface IMoneyFormat{
    String format(int i);
}

class MyMoney{
    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }

    public void printMoney(IMoneyFormat moneyFormat){
        System.out.println("我的存款:" + moneyFormat.format(this.money));
    }
}*/
