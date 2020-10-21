package com.zgy.learn.createtype.factoryeasy;

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
        // 使用简单工厂模式
        myCarFromFactory();
    }

    // 原始的方法
    public static void myCar() {
        Car car1 = new Audi();
        Car car2 = new Tesla();
        car1.name();
        car2.name();
    }

    // 使用工厂方式，我们不用去关心其中的细节
    public static void myCarFromFactory() {
        Car audi = CarFactory.getCar("Audi");
        Car tesla = CarFactory.getCar("Tesla");
        audi.name();
        tesla.name();
    }
}
