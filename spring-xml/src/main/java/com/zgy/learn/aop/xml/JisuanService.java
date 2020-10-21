package com.zgy.learn.aop.xml;

import java.util.function.BiFunction;

/**
 * @Author: renjiaxin
 * @Despcription: 计算， 使用java8， 输入两个参数，返回一个值，应该使用BiFunction
 * @Date: Created in 2019/10/18 4:27
 * @Modified by:
 */
public class JisuanService {
    public int operate(Integer x, Integer y, BiFunction<Integer, Integer, Integer> z) {
        return z.apply(x, y);
    }

    public void test() {
        System.out.println("test");
    }

    public void show(String name) {
        System.out.println("计算的人是：" + name);

    }
}
