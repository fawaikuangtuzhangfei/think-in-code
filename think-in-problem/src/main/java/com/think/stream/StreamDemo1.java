package com.think.stream;

import java.util.stream.IntStream;

/**
 * Stream初探
 * @author Java男朋友
 * @date 2021-12-05 9:08
 */
public class StreamDemo1 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        // 外部迭代
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        System.out.println("结果:" + sum  );

        //Stream内部迭代
        // map 就是中间操作（返回的仍是Stream)
        // sum 是终止操作
        // 返回流的都是中间操作。返回值的是终止操作
        int sum1 = IntStream.of(nums).map(StreamDemo1::doubleNum).sum();
        System.out.println("结果:" + sum1);

        // 惰性求值就是没有终止操作调用的情况下，中间操作不会执行
        System.out.println("============惰性================");
        IntStream.of(nums).map(StreamDemo1::doubleNum);
    }

    public static int doubleNum(int i){
        System.out.println("乘2");
        return i*2;
    }
}
