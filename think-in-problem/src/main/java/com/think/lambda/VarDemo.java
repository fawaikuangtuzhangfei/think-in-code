package com.think.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * lambda变量引用
 * 匿名函数调用外部变量时，必须声明为final(JDK8可以不显示声明），保证不能修改，保证内外是同一对象
 * @author Java男朋友
 * @date 2021-12-04 18:42
 */
public class VarDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // Java传参数时传的是值，而不是引用
        Consumer<String> consumer = s -> System.out.println(list + s);
        consumer.accept("20211204");
    }

}
