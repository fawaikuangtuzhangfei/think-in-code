package com.think.design.factory.simple.practise;

/**
 * 使用简单工厂模式设计一个可以创建不同几何形状（如圆形、方形和三角形等）的绘图工具，
 * 每个几何图形都具有绘制draw()和擦除erase()两个方法，要求在绘制不支持的几何图形时，提示一个UnSupportedShapeException。
 * @author yc
 * @description
 * @date 2021-09-23 12:06
 */
public class DrawPicture {
    public static void main(String[] args) {
        PictureDraw circle = DrawFactory.drawPicture("rectangle");
        circle.draw();
        PictureDraw circle1 = DrawFactory.drawPicture("circle");
        circle1.erase();
        DrawFactory.drawPicture("cc").draw();
    }
}

class DrawFactory{

    public static PictureDraw drawPicture(String type){
        switch (type){
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            default:
                throw new RuntimeException("UnSupportedShapeException");
        }
    }
}

interface PictureDraw{
    void draw();
    void erase();
}

class Rectangle implements PictureDraw{

    @Override
    public void draw() {
        System.out.println("长方形");
    }

    @Override
    public void erase() {
        System.out.println("擦长方形");
    }
}

class Circle implements PictureDraw{

    @Override
    public void draw() {
        System.out.println("圆");
    }

    @Override
    public void erase() {
        System.out.println("擦除圆");

    }
}
