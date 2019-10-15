package com.zgy.learn.java8.stream;

import com.zgy.learn.java8.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 创建Stream的三个步骤
 * 1. 创建Stream
 * 2. 中间操作
 * 3. 终止操作
 */
public class SimpleStream {
    @Test
    public void testCreateStream() {
        // 1.Collection来获取流，stream()或者paralleralStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();


        // 2. Arrays中的静态stream方法来获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        // 3. Stream类中的of()方法，可以创建Stream
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        // 4. 通过函数，创建无限流, 停不下来，可以使用limit控制
        // 迭代
        // 后面的()-> x+2表示的是中间操作
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        // 这是一个终止操作
        stream4.limit(10).forEach(System.out::println);

        // 生成
        Stream.generate(() -> Math.random() * 100).forEach(System.out::println);

    }

}
