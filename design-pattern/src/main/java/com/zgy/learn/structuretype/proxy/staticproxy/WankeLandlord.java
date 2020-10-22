package com.zgy.learn.structuretype.proxy.staticproxy;

/**
 * @Author: renjiaxin
 * @Despcription: 真实的主题，就是一个具体的主人，他想去出租房屋
 * @Date: Created in 2020/2/28 9:48
 * @Modified by:
 */
public class WankeLandlord implements Landlord {
    @Override
    public void rentOut() {
        System.out.println("万科房东要出租房屋!");
    }
//    // 也可以用extends方式，但是最好使用组合模式
//    private Landlord landlord;
//
//    public void setLandlord(Landlord landlord) {
//        this.landlord = landlord;
//    }
//
//    @Override
//    public void rentOut() {
//        // 调用被代理者的方式，实现静态代理模式
//        landlord.rentOut();
//    }
}
