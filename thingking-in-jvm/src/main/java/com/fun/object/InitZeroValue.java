package com.fun.object;

import java.math.BigDecimal;

/**
 * Java对象的零值
 * @author Java男朋友
 * @date 2021-09-01 8:40
 */
public class InitZeroValue {

    private int age;
    private Integer value;
    private boolean flag;
    private Object data;
    private String name;
    private int[] people;
    private BigDecimal money;

    public void print(){
        int a;
        // 局部变量必须初始化
//        System.out.println(a);
        System.out.println(name + " " + age  + " " +  value + " " +  flag + " " + data);
        System.out.println(people);
        System.out.println(money);
    }

    public static void main(String[] args) throws Exception {
        InitZeroValue initZeroValue = new InitZeroValue();
        initZeroValue.print();
    }
}
