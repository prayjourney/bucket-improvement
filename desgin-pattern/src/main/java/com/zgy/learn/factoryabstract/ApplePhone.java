package com.zgy.learn.factoryabstract;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/23 22:55
 * @Modified by:
 */
public class ApplePhone implements PhoneProduct {
    @Override
    public void open() {
        System.out.println("iPhone开机");
    }

    @Override
    public void shutDown() {
        System.out.println("iPhone关机");

    }

    @Override
    public void sendSMS() {
        System.out.println("iPhone发短信");
    }

    @Override
    public void callUp() {
        System.out.println("iPhone打电话");
    }
}
