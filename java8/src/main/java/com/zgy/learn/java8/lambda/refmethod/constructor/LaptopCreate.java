package com.zgy.learn.java8.lambda.refmethod.constructor;

import java.util.function.Function;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/15 3:06
 * @Modified by:
 */
public class LaptopCreate {
    public static void main(String[] args) {
        // 一定要是参数要对应一致
        Function<String, Laptop> fun1 = (n1) -> new Laptop(n1);
        Function<String, Laptop> fun2 = Laptop::new;
        System.out.println(fun1.apply("索尼"));
        Laptop laptop = fun2.apply("Mac");
        System.out.println(laptop);

    }
}
