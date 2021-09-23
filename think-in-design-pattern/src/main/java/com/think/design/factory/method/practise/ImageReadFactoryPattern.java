package com.think.design.factory.method.practise;

/**
 * 使用工厂方法模式设计一个程序来读取各种不同类型的图片格式，针对每一种图片格式都设计一个图片读取器，
 * 如GIF图片读取器用于读取GIF格式的图片、JPG图片读取器用于读取JPG格式的图片。需充分考虑系统的灵活性和可扩展性。
 * @author yc
 * @description
 * @date 2021-09-23 15:06
 */
public class ImageReadFactoryPattern {
    public static void main(String[] args) {
        ImageFactory imageFactory = new JpegImageFactory();
        ImageReader image = imageFactory.getImage();
        image.readImage();
    }
}

interface ImageReader {
    void readImage();
}

class JpegImage implements ImageReader {

    @Override
    public void readImage() {
        System.out.println("jpeg");
    }
}

class GifImage implements ImageReader {

    @Override
    public void readImage() {
        System.out.println("gif");
    }
}

interface ImageFactory{
    ImageReader getImage();
}

class JpegImageFactory implements ImageFactory{

    @Override
    public ImageReader getImage() {
        System.out.println("新建jpeg图片...");
        return new JpegImage();
    }
}

class GifImageFactory implements ImageFactory{

    @Override
    public ImageReader getImage() {
        System.out.println("新建gif图片...");
        return new GifImage();
    }
}

