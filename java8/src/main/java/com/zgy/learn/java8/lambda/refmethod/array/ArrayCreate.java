package com.zgy.learn.java8.lambda.refmethod.array;

import java.util.function.Function;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/15 3:14
 * @Modified by:
 */
public class ArrayCreate {
    public static void main(String[] args) {
        // 问题：如何创建String的数组呢？
        Function<Integer, Integer[]> fun1 = (n1) -> new Integer[n1];
        Function<String, String[]> fun2 = (n1) -> new String[n1.length()];
        Function<Integer, Integer[]> fun3 = Integer[]::new;
        // 有问题
        // Function<String, String[]> fun4 = String[]::new;
        Integer[] i1 = fun1.apply(5);
        System.out.println("i1的长度: " + i1.length);
        String[] i2 = fun2.apply("nihao====");
        System.out.println("i2的长度: " + i2.length);
        Integer[] i3 = fun3.apply(3);
        System.out.println("i3的长度: " + i3.length);

    }
}
