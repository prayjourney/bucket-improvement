package com.zgy.learn.factorymethod;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/23 22:01
 * @Modified by:
 */
public class AudiFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Audi();
    }
}
