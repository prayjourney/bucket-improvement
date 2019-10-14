package com.zgy.learn.java8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 使用定制的方法，对List排序
 */
public class EmpLambda {
    List<Employee> emps = Arrays.asList(
            new Employee(100, "关羽", 35, 19000),
            new Employee(101, "张飞", 32, 13000),
            new Employee(102, "刘备", 37, 30000),
            new Employee(105, "诸葛亮", 29, 20000),
            new Employee(107, "赵云", 31, 18000),
            new Employee(109, "马超", 31, 18000),
            new Employee(109, "马超", 32, 20000),
            new Employee(120,"黄忠", 60, 19000)
    );

    @Test
    public void test() {
        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge() == e2.getAge())
                return e1.getName().compareTo(e2.getName());
            else return - Integer.compare(e1.getAge(), e2.getAge());
        });
        for (Employee e : emps) {
            System.out.println(e);
        }

    }
}
