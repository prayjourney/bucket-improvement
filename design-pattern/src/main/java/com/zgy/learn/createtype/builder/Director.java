package com.zgy.learn.createtype.builder;

/**
 * @Author: renjiaxin
 * @Despcription: 指挥，核心，负责指挥构建一个工程，工程如何构建，由他来决定
 * @Date: Created in 2020/2/24 1:18
 * @Modified by:
 */
public class Director {
    // 指挥工人，构建Car, 具体的步骤，就在此处决定的
    public Car build(Builder builder) {
        builder.buildA("雅马哈底盘");
        builder.buildB("米其林轮胎");
        builder.buildC("斯巴鲁引擎");
        builder.buildD("奥迪车壳");
        return builder.getCar();
    }
}
