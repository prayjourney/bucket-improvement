package com.zgy.learn.factoryabstract;

/**
 * @Author: renjiaxin
 * @Despcription: 专门负责生产小米的产品
 * @Date: Created in 2020/2/23 23:01
 * @Modified by:
 */
public class XiaomiFactory implements AbstractProductFactory {
    @Override
    public PcProduct createPc() {
        return new XiaomiPc();
    }

    @Override
    public PhoneProduct createPhone() {
        return new XiaomiPhone();
    }
}
