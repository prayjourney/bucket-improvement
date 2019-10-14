package com.zgy.learn.java8.lambda.own;

@FunctionalInterface
public interface CalculateInterface<T> {
    public T calcuate(T t1, T t2);
}
