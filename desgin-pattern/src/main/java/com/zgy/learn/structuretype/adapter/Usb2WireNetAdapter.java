package com.zgy.learn.structuretype.adapter;

/**
 * @Author: renjiaxin
 * @Despcription: usb2wire
 * @Date: Created in 2020/2/27 22:49
 * @Modified by:
 */
public class Usb2WireNetAdapter extends WireAdaptee implements NetAdapter {
    // 使用继承的方式来实现上网，这样不好
    @Override
    public void handler() {
        super.goToNet();
    }
}
