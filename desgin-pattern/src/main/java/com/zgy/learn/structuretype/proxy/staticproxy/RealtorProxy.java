package com.zgy.learn.structuretype.proxy.staticproxy;

/**
 * @Author: renjiaxin
 * @Despcription: 房地产经纪人，也就是中介公司，此处叫做代理
 * @Date: Created in 2020/2/28 9:47
 * @Modified by:
 */
public class RealtorProxy implements Landlord {
    private Landlord landlord;

    public RealtorProxy() {
    }

    // 构造器注入，这个效率要高一些
    public RealtorProxy(Landlord landlord) {
        this.landlord = landlord;
    }

    // set方法注入
    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    @Override
    public void rentOut() {
        // 代理实现了出租
        landlord.rentOut();
    }

    public void watchHouse(){
        System.out.println("带领租客看房子");
    }

    public void fixRefrigerator(){
        System.out.println("帮租客修理冰箱");
    }

}