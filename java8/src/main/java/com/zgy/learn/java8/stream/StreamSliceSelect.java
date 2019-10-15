package com.zgy.learn.java8.stream;

import com.zgy.learn.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: renjiaxin
 * @Despcription: Stream的筛选和切片
 * @Date: Created in 2019/10/16 2:27
 * @Modified by:
 */
public class StreamSliceSelect {
    List<Employee> emps = Arrays.asList(
            new Employee(100, "关羽", 35, 19000),
            new Employee(101, "张飞", 32, 13000),
            new Employee(102, "刘备", 37, 30000),
            new Employee(105, "诸葛亮", 29, 20000),
            new Employee(107, "赵云", 31, 18000),
            new Employee(109, "马超", 31, 18000),
            new Employee(109, "马超", 32, 20000),
            new Employee(120, "黄忠", 60, 19000)
    );

    /**
     * 筛选与切片
     * filter(Predicatep) 接收Lambda ，从流中排除某些元素。
     * distinct() 筛选，通过流所生成元素的hashCode() 和equals() 去除重复元素
     * limit(long maxSize) 截断流，使其元素不超过给定数量。
     * skip(long n) 跳过元素，返回一个扔掉了前n 个元素的流。若流中元素不足n 个，则返回一个空流。与limit(n) 互补
     */

    @Test
    public void testFilter() {
        // 生成流
        Stream<Employee> stream = emps.stream();
        // 中间操作 + 终止操作
        stream.filter((x) -> x.getAge() > 35).forEach(System.out::println);
    }

    @Test
    public void testLimitSkip() {
        Stream<Double> stream = Stream.generate(() -> Math.random()).limit(20).skip(2);
        stream.forEach(System.out::println);
    }
}
