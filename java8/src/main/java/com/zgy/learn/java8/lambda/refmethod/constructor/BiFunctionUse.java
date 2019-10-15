package com.zgy.learn.java8.lambda.refmethod.constructor;

import com.zgy.learn.java8.lambda.Employee;

import java.util.function.BiFunction;

/**
 * @Author: renjiaxin
 * @Despcription: 断言型接口使用，配合构造器引用
 * @Date: Created in 2019/10/15 23:49
 * @Modified by:
 */

public class BiFunctionUse {
    public static void main(String[] args) {
        // bt1和bt2是等价的
        BiFunction<Integer, String, Employee> bt1 = (age, name) -> new Employee(age, name);
        BiFunction<Integer, String, Employee> bt2 = Employee::new;
        Employee e1 = bt1.apply(27, "李四");
        Employee e2 = bt2.apply(22, "张三");
        System.out.println(e1);
        System.out.println(e2);

    }
}