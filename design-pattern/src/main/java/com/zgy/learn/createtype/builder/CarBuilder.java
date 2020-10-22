package com.zgy.learn.createtype.builder;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/24 1:01
 * @Modified by:
 */
public class CarBuilder extends Builder {
    // 定义一个car， 在这个具体的构造者手里，直接就会给一个可以使用的产品，
    // 而工厂模式，更多的是生产零件的感觉，建造者更多生产一个完整的东西
    private Car car;

    // 工人负责创建产品，是具体的工作人员
    CarBuilder() {
        car = new Car();
    }

    @Override
    void buildA(String str) {
        car.setBaseplate(str); // 组装底盘
    }

    @Override
    void buildB(String str) {
        car.setTyre(str); // 组装轮胎
    }

    @Override
    void buildC(String str) {
        car.setEngine(str); // 组装引擎
    }

    @Override
    void buildD(String str) {
        car.setShell(str); // 组装外壳
    }

    @Override
    Car getCar() {
        return car;
    }
}
