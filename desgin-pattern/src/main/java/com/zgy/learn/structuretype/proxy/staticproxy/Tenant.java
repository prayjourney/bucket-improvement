package com.zgy.learn.structuretype.proxy.staticproxy;

/**
 * @Author: renjiaxin
 * @Despcription: 租户，需要找一个房子住，没法直接找房东，那就找房屋代理
 * @Date: Created in 2020/2/28 9:51
 * @Modified by:
 */
public class Tenant {
    public static void main(String[] args) {
        /*
        // 如果我能直接找到房东，那也就可以去租房了，但问题是找不到
        Landlord landlord = new WankeLandlord();
        landlord.rentOut();
         */
        // 代理方式，实现出租
        Landlord landlord = new WankeLandlord();
        RealtorProxy proxy = new RealtorProxy(landlord);
        // 这个是代理方法
        proxy.rentOut();

        // 这是代理类的扩展方法，并没有去修改真实对象的类，符合开闭原则
        proxy.watchHouse();
        proxy.fixRefrigerator();

    }
}
