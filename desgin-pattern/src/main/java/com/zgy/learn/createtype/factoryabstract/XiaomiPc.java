package com.zgy.learn.createtype.factoryabstract;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/23 22:54
 * @Modified by:
 */
public class XiaomiPc implements  PcProduct {
    @Override
    public void open() {
        System.out.println("小米开机");
    }

    @Override
    public void shutDown() {
        System.out.println("小米关机");
    }

    @Override
    public void writeNovel() {
        System.out.println("小米写小说");
    }

    @Override
    public void playGame() {
        System.out.println("小米玩游戏");
    }
}
