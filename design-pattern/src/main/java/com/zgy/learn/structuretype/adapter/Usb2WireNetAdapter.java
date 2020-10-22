package com.zgy.learn.structuretype.adapter;

/**
 * @Author: renjiaxin
 * @Despcription: usb2wire
 * @Date: Created in 2020/2/27 22:49
 * @Modified by:
 */
public class Usb2WireNetAdapter implements NetAdapter {
    // 使用组合的方式，来完成了适配器模式，面向接口编程的思想符合
    WireAdaptee wire = new WireAdaptee();

    @Override
    public void handler() {
        wire.goToNet();
    }
//public class Usb2WireNetAdapter extends WireAdaptee implements NetAdapter {
//    // 使用继承的方式来实现上网，这样不好
//    @Override
//    public void handler() {
//        super.goToNet();
//    }

}
