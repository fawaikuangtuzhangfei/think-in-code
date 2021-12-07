package com.think.stream;

import com.think.stream.bean.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 收集器
 *  PS:没测试处理->最好使用方法引用，这样就不会生成一个类似 lambda$0 这样的函数
 * @author Java男朋友
 * @date 2021-12-05 17:19
 */
public class CollectDemo {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student());

        // 得到所有学生的年龄列表
        Set<Integer> collect = list.stream().map(Student::getAge).collect(Collectors.toSet());
        List<Integer> collect2 = list.stream().map(i -> i.getAge()).collect(Collectors.toList());

        // 统计汇总信息 总数、求和、最大、最小、平均
        IntSummaryStatistics ageSummary = list.stream().collect(Collectors.summarizingInt(Student::getAge));

        // 分块-按照性别-只有两种
        Map<Boolean, List<Student>> gender = list.stream().collect(Collectors.partitioningBy(s -> s.getSex() == 1));

        // 分组-按照年龄分组-有多少不同就有多少
        Map<Integer, List<Student>> ageMap = list.stream().collect(Collectors.groupingBy(Student::getAge));

        // 得到所有年龄学生的个数
        Map<Integer, Long> age = list.stream()
                .collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));



    }
}
