package com.think.design.factory.enmu;

/**
 * @author Java男朋友
 * @date 2021-11-08 8:37
 */
public enum PizzaType {

    CHESS("chess", "棋风味"), CLAM("clam", "蛤风味");


    private String code;
    private String name;

    PizzaType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
