package com.think.lambda;

import java.util.function.Function;

/**
 * 级联表达式和柯里化
 * 柯里化：把多个参数的函数转换为只有一个参数的函数
 * 柯里化的目的：函数标准化
 * 高阶函数：返回函数的函数
 * @author Java男朋友
 * @date 2021-12-04 19:32
 */
public class CurryDemo {

    public static void main(String[] args) {
        // 实现了x+y的级联表达式
        Function<Integer, Function<Integer, Integer>> function = x -> y -> x + y;
        System.out.println(function.apply(2).apply(3));

        // 实现三个数字相加
        Function<Integer, Function<Integer, Function<Integer, Integer>>> fun = x -> y -> z -> x + y + z;
        System.out.println(fun.apply(1).apply(2).apply(3));

        int[] nums = {2,3,4};
        Function f = fun;
        for (int num : nums) {
            if(f instanceof Function){
                Object apply = f.apply(num);
                if(apply instanceof Function){
                    f = (Function) apply;
                }else{
                    System.out.println("调用结束,结果为:" + apply);
                }
            }
        }
    }
}
