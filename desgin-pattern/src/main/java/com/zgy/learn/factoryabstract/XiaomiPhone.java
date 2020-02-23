package com.zgy.learn.factoryabstract;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/23 22:55
 * @Modified by:
 */
public class XiaomiPhone implements PhoneProduct {
    @Override
    public void open() {
        System.out.println("小米开机");
    }

    @Override
    public void shutDown() {
        System.out.println("小米关机");
    }

    @Override
    public void sendSMS() {
        System.out.println("小米发短信");
    }

    @Override
    public void callUp() {
        System.out.println("小米打电话");
    }
}
