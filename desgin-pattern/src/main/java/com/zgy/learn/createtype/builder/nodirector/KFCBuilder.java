package com.zgy.learn.createtype.builder.nodirector;

/**
 * @Author: renjiaxin
 * @Despcription: 抽象的KFC点餐建造者
 * @Date: Created in 2020/2/24 1:33
 * @Modified by:
 */
public abstract class KFCBuilder {
    abstract  KFCBuilder buildA(String str); // 薯条
    abstract  KFCBuilder buildB(String str); // 可乐
    abstract  KFCBuilder buildC(String str); // 炸鸡

    // 获得产品
    abstract KFCRecipes getRecipes();
}
