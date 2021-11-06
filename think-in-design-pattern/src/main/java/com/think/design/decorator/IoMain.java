package com.think.design.decorator;

import java.io.*;

/**
 * 测试Java IO
 * Java IO类中 InputStream 是组件基类
 * FileInputStream 是具体组件类
 *
 * FilterInputStream 是装饰类基类
 * StringBufferInputStream 等是具体的装饰类
 *
 * @author Java男朋友
 * @date 2021-11-06 18:32
 */
public class IoMain {

    public static void main(String[] args) throws IOException {
        InputStream in = new BufferedInputStream(new FileInputStream("D:\\temp\\test.txt"));
        FileInputStream fileInputStream = new FileInputStream("D:\\temp\\test.txt");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        // 实现一个装饰类，把输入流中的全部大写字符转换为小写
        int c;
        InputStream in2 = new LowerCaseInputStream(new FileInputStream("D:\\temp\\test.txt"));
        while ((c = in2.read()) > 0){
            System.out.print((char) c);
        }
    }

    static class LowerCaseInputStream extends FilterInputStream {

        protected LowerCaseInputStream(InputStream in) {
            super(in);
        }

        @Override
        public int read() throws IOException {
            int read = super.read();
            return read != -1 ? Character.toLowerCase(read) : read;
        }
    }
}
