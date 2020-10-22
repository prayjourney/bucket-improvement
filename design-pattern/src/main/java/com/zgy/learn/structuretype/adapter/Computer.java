package com.zgy.learn.structuretype.adapter;

/**
 * @Author: renjiaxin
 * @Despcription: 需要上网
 * @Date: Created in 2020/2/27 22:48
 * @Modified by:
 */
public class Computer {
    public void net(NetAdapter adapter) {
        // 上网的具体方式，不能直接连，所以有个转换器
        adapter.handler();
    }

    public static void main(String[] args) {
        // 客户端
        Computer computer = new Computer();
        // 适配器[的具体实现类]
        Usb2WireNetAdapter usbNetAdapter = new Usb2WireNetAdapter();
        computer.net(usbNetAdapter);

    }

}
