package com.zgy.learn.createtype.factoryabstract;

/**
 * @Author: renjiaxin
 * @Despcription: 工厂的工厂，具体的工厂各自去实现，但是这个工厂定义了他的子类的工厂可以做什么
 * @Date: Created in 2020/2/23 22:59
 * @Modified by:
 */
public interface AbstractProductFactory {
    PcProduct createPc();
    PhoneProduct createPhone();
}
