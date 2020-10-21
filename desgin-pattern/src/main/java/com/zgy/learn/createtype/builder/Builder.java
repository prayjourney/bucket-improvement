package com.zgy.learn.createtype.builder;

/**
 * @Author: renjiaxin
 * @Despcription: 抽象的构造者，下面定义了四个工序
 * @Date: Created in 2020/2/24 0:59
 * @Modified by:
 */
public abstract class Builder {
    // 四个步骤
    abstract void buildA(String str);
    abstract void buildB(String str);
    abstract void buildC(String str);
    abstract void buildD(String str);

    // 完工后，得到这个具体的产品
    abstract Car getCar();
}
