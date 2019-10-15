package com.zgy.learn.java8.stream;

import com.zgy.learn.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription: 映射
 * @Date: Created in 2019/10/16 3:00
 * @Modified by:
 */
public class StreamMap {
    /**
     * 映射
     * map(Functionf)
     * 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * mapToDouble(ToDoubleFunction f)
     * 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的DoubleStream。
     * mapToInt(ToIntFunction f)
     * 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的IntStream。
     * mapToLong(ToLongFunction f)
     * 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的LongStream。
     * flatMap(Function f)
     * 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void testMap() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee", "ff");
        list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);


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
        emps.stream().map(employee -> {
            System.out.println("start show!");
            return employee.getName();
        }).limit(5).forEach(System.out::println);
        emps.stream().map((Employee::getName)).forEach(System.out::println);
    }

}