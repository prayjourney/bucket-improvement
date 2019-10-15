package com.zgy.learn.java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/16 3:26
 * @Modified by:
 */
public class CommonUseData {
    public static List<Employee> emps = Arrays.asList(
            new Employee(100, "关羽", 35, 19000),
            new Employee(101, "张飞", 32, 13000),
            new Employee(102, "刘备", 37, 30000),
            new Employee(105, "诸葛亮", 29, 20000),
            new Employee(107, "赵云", 31, 18000),
            new Employee(109, "马超", 31, 18000),
            new Employee(109, "马超", 32, 20000),
            new Employee(120,"黄忠", 60, 19000)
    );
}
