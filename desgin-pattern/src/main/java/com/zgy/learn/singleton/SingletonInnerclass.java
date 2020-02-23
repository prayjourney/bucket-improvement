package com.zgy.learn.singleton;

/**
 * @Author: renjiaxin
 * @Despcription: 单例的静态内部类的实现，线程安全，效率高
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
    public static void main(String[] args) {
        SingletonInnerclass instance1 = SingletonInnerclass.getInstance();
        SingletonInnerclass instance2 = SingletonInnerclass.getInstance();
        System.out.println(instance1 == instance2);
    }
}