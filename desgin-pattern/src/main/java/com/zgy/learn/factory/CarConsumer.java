package com.zgy.learn.factory;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/23 22:04
 * @Modified by:
 */
public class CarConsumer {
    public static void main(String[] args) {
        CarFactory factory1 = new TeslaFactory();
        CarFactory factory2 = new AudiFactory();
        factory1.getCar().carName();
        factory2.getCar().carName();
    }
}
