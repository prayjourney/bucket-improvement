package com.zgy.learn.structuretype.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/28 12:38
 * @Modified by:
 */
public class Customer {
    public static void main(String[] args) {
        // 真实角色
        Haitao ht = new XiaomingHaitao();
        // 代理角色, 现在没有，但是要动态生成，通过InvocationHandler
        HaitaoDynamicProxy proxy = new HaitaoDynamicProxy(ht);
        Haitao instance = (Haitao) proxy.getProxyInstance();
        instance.buy();
        proxy.checkGoods();
        proxy.findWhere();

    }
}
