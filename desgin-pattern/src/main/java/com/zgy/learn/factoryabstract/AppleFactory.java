package com.zgy.learn.factoryabstract;

/**
 * @Author: renjiaxin
 * @Despcription: 专门负责生产Apple的产品
 * @Date: Created in 2020/2/23 23:01
 * @Modified by:
 */
public class AppleFactory implements AbstractProductFactory {
    @Override
    public PcProduct createPc() {
        return new ApplePc();
    }

    @Override
    public PhoneProduct createPhone() {
        return new ApplePhone();
    }
}
