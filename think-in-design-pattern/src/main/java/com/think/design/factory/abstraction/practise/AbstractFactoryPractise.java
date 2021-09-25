package com.think.design.factory.abstraction.practise;

/**
 * 练习
 *
 * Sunny软件公司欲推出一款新的手机游戏软件，
 * 该软件能够支持Symbian、Android和Windows Mobile等多个智能手机操作系统平台，
 * 针对不同的手机操作系统，该游戏软件提供了不同的游戏操作控制(OperationController)类
 * 和游戏界面控制(InterfaceController)类，并提供相应的工厂类来封装这些类的初始化过程。
 * 软件要求具有较好的扩展性以支持新的操作系统平台，为了满足上述需求，试采用抽象工厂模式对其进行设计。
 *
 * 产品族：
 * Symbian、Android和Windows Mobil
 *
 * 产品体系结构：
 * 游戏控制、界面控制
 *
 * 如果用工厂方法的话？
 *  对于每个操作系统来说都需要一个抽象产品 Symbian、Android和Windows Mobil
 *  抽象产品下有具体的工厂生产基于不同操作的工厂
 * 用抽象工厂的话
 *  相当于把操作系统抽象出来了，并且拥有全部的操作（如果操作是固定的）
 *  具体的产品Symbian、Android和Windows Mobil只需要继承抽象工厂，并创建拥有对应操作的子类
 *
 * 相同点是：对于操作来说仍需要抽象出其父类工厂，由子类完成具体的实现
 *
 * @author yc
 * @description
 * @date 2021-09-24 22:23
 */
public class AbstractFactoryPractise {
    public static void main(String[] args) {
        SystemAbstractFactory systemAbstractFactory = new SymbianFactory();
        systemAbstractFactory.getAbstractInterfaceController().interfaceOperation();
    }
}


interface AbstractInterfaceController {
    void interfaceOperation();
}

interface AbstractOperationController {
    void operationControl();
}

class Symbian implements AbstractInterfaceController {

    @Override
    public void interfaceOperation() {
        System.out.println("Sym下ic");
    }
}

class Android implements AbstractOperationController{

    @Override
    public void operationControl() {
        System.out.println("AndroidGame oc");
    }
}

interface SystemAbstractFactory{
    AbstractInterfaceController getAbstractInterfaceController();
    AbstractOperationController getAbstractOperationController();
}


class SymbianFactory implements SystemAbstractFactory{

    public SymbianFactory() {
        System.out.println("Symbian 初始化");
    }

    @Override
    public AbstractInterfaceController getAbstractInterfaceController() {
        return new Symbian();
    }

    @Override
    public AbstractOperationController getAbstractOperationController() {
        return new Android();
    }
}