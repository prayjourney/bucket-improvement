package com.zgy.learn.factoryabstract;

/**
 * @Author: renjiaxin
 * @Despcription: phone的产品，里面有具体的功能，但是需要各自去实现
 * @Date: Created in 2020/2/23 22:47
 * @Modified by:
 */
public interface PhoneProduct {
    void open();
    void shutDown();
    void sendSMS();
    void callUp();
}
