package com.zgy.learn.factoryabstract;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/23 22:54
 * @Modified by:
 */
public class ApplePc implements PcProduct {
    @Override
    public void open() {
        System.out.println("Mac开机");
    }

    @Override
    public void shutDown() {
        System.out.println("Mac关机");
    }

    @Override
    public void writeNovel() {
        System.out.println("Mac写小说");
    }

    @Override
    public void playGame() {
        System.out.println("Mac玩游戏");
    }
}