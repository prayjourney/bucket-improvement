package com.zgy.learn.createtype.factoryabstract;

/**
 * @Author: renjiaxin
 * @Despcription: pc的产品，里面有具体的功能，但是需要各自去实现
 * @Date: Created in 2020/2/23 22:48
 * @Modified by:
 */
public interface PcProduct {
    void open();
    void shutDown();
    void writeNovel();
    void playGame();
}
