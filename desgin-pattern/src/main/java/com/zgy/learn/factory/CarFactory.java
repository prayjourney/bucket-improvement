package com.zgy.learn.factory;

/**
 * @Author: renjiaxin
 * @Despcription: 为了满足开闭原则，使用工厂方法模式，需要一个车工场的接口
 * @Date: Created in 2020/2/23 21:54
 * @Modified by:
 */
public interface CarFactory {
    Car getCar();
}
