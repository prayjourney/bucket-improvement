package com.zgy.learn.structuretype.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: renjiaxin
 * @Despcription: 这个用来生成动态代理，根据传入的类型，自动生成。每个代理对象都会关联一个InvocationHandler，调用程序实现的接口
 * @Date: Created in 2020/2/28 11:44
 * @Modified by:
 */
public class HaitaoDynamicProxy implements InvocationHandler {
    // 被代理的接口[对象]
    private Object target;

    public HaitaoDynamicProxy() {
    }

    public HaitaoDynamicProxy(Object target) {
        this.target = target;
    }

    // 动态生成代理对象
    public Object getProxyInstance() {
        Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
        return proxyInstance;
    }

    // 处理代理实例，并且返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 动态代理的本质，就是使用反射机制
        goodsRequire();
        Object result = method.invoke(target, args);
        return result;
    }

    // 代理方法增强
    public void goodsRequire() {
        System.out.println("服务咨询！");
    }

    public void checkGoods() {
        System.out.println("真伪检验!");
    }

    public void findWhere() {
        System.out.println("查询目前到哪儿了!");
    }


}
