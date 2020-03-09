package com.zgy.learn.java8.kuangs;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author: renjiaxin
 * @Despcription: 四大基本函数式接口，函数型接口，消费型接口，供给型接口，断言型接口
 * @Date: Created in 2020/3/9 20:21
 * @Modified by:
 */
//     * 消费型接口：无返回值，一个参数
//     * 供给型接口：有返回值，无参数
//     * 函数型接口：有返回值，一个参数
//     * 断言型接口：boolean返回值，一个参数
public class Big4Interface {
    public static void main(String[] args) {
        usePredicate();
        useFunction();

    }

    /**
     * 段言行接口，返回一个布尔值，一个参数，Predicate
     */
    public static void usePredicate() {
        // 传统方式
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 100;
            }
        };
        System.out.println(predicate.test(102));
        // 函数式方式，都可以转换为lambda表达式，()->{};
        Predicate<Integer> predicate2 = (num) -> {
            return num > 100;
        };
        System.out.println(predicate2.test(111));
    }

    /**
     * 函数型接口，1个参数，1个返回值，Function
     */
    public static void useFunction() {
        // 传统方式
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println(function.apply("my dream！"));

        // 函数式方式
        Function<String, Integer> function2 = (s1) -> {
            return s1.length();
        };
        System.out.println(function2.apply("renjiaxin!!!"));

    }
}
