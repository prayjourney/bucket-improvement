package com.zgy.learn.createtype.singleton;

import java.lang.reflect.Constructor;

/**
 * @Author: renjiaxin
 * @Despcription: 单例的静态内部类的实现，线程安全，效率高， 使用反射可以破坏单例模式
 * @Date: Created in 2020/2/23 12:57
 * @Modified by:
 */
public class SingletonInnerclass {
    private SingletonInnerclass() {
    }

    private static class Innercls4Singleton {
        // 内部类的一个属性
        private static SingletonInnerclass instance = new SingletonInnerclass();
    }

    public static SingletonInnerclass getInstance() {
        return Innercls4Singleton.instance;
    }
}

// 测试
class SingletonInnerclassTest {
    public static void main(String[] args) throws Exception {
        SingletonInnerclass instance1 = SingletonInnerclass.getInstance();
        SingletonInnerclass instance2 = SingletonInnerclass.getInstance();
        System.out.println(instance1 == instance2);
        // 但是可以使用反射来破坏单例模式
        Constructor<SingletonInnerclass> constructor = SingletonInnerclass.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        // 使用反射，来创建对象了
        SingletonInnerclass innerInstance1 = constructor.newInstance();
        SingletonInnerclass innerInstance2 = constructor.newInstance();
        System.out.println(innerInstance1 == innerInstance2);
        System.out.println("innerInstance1: " + innerInstance1.hashCode());
        System.out.println("innerInstance2: " + innerInstance2.hashCode());
    }
}