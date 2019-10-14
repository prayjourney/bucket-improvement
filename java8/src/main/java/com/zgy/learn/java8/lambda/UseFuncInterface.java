package com.zgy.learn.java8.lambda;

public class UseFuncInterface {
    /**
     * lambda表达式需要函数式接口的支持--->什么是函数式接口呢？
     * 函数式接口： 只有一个抽象方法的接口， 可以使用FunctionalInterface注解修饰，当做一个检查，如同Override注解
     *
     * @param args
     */
    public static void main(String[] args) {
        new UseFuncInterface().test(20);
    }

    public Integer operation(Integer num, MyFuncInterface<Integer> mf) {
        return mf.getValue(num);
    }

    // 接口的实现直到此处才去进行
    public void test(int s) {
        Integer num = operation(s, (x) -> x * x - s);
        System.out.println("结果是：" + num);
    }
}
