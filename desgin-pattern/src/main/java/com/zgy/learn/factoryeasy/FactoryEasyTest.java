package com.zgy.learn.factoryeasy;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/23 20:42
 * @Modified by:
 */
public class FactoryEasyTest {
    public static void main(String[] args) {
        // 原始的方法
        myCar();

    }

    // 原始的方法
    public static void myCar() {
        Car car1 = new Audi();
        Car car2 = new Tesla();
        car1.name();
        car2.name();
    }
}
