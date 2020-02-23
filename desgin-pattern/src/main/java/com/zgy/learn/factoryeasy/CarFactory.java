package com.zgy.learn.factoryeasy;

/**
 * @Author: renjiaxin
 * @Despcription: Car的工厂方法
 * @Date: Created in 2020/2/23 20:49
 * @Modified by:
 */
public class CarFactory {
    public static Car getCar(String car) {
        if ("Audi".equals(car)) {
            return new Audi();
        } else if ("Tesla".equals(car)) {
            return new Tesla();
        } else {
            return null;
        }
    }
}
