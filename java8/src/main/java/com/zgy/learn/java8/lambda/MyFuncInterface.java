package com.zgy.learn.java8.lambda;

/**
 * 这就是一个函数式接口
 *
 * @param <T>
 */
@FunctionalInterface
public interface MyFuncInterface<T> {
    T getValue(T t);
}
