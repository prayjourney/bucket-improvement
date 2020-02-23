package com.zgy.learn.factoryabstract;

/**
 * @Author: renjiaxin
 * @Despcription: 用户类，使用和调用
 * @Date: Created in 2020/2/23 22:55
 * @Modified by:
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("============小米产品===========");
        AbstractProductFactory xiaomiFactory = new XiaomiFactory();
        PcProduct pc = xiaomiFactory.createPc();
        pc.open();
        pc.playGame();
        PhoneProduct phone = xiaomiFactory.createPhone();
        phone.sendSMS();
        phone.callUp();

        System.out.println("============Apple产品===========");
        AbstractProductFactory appleFactory = new AppleFactory();
        PhoneProduct iPhone = appleFactory.createPhone();
        iPhone.open();
        iPhone.sendSMS();

    }
}
