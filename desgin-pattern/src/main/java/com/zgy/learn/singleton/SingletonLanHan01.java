package com.zgy.learn.singleton;

/**
 * @Author: renjiaxin
 * @Despcription: 单例懒汉实现， 线程安全，能延时加载，线程安全，效率低
 * @Date: Created in 2020/2/23 11:55
 * @Modified by:
 */
public class SingletonLanHan01 {
    // 1. 构造器私有化
    private SingletonLanHan01() {
    }

    // 2. 保证一个类只有一个实例, 不去立即加载该对象
    private static SingletonLanHan01 lanHaninstance;

    // 3. 提供一个全局的访问方式, 由于多线程问题，需要使用到synchronized关键字，效率较低
    public static synchronized SingletonLanHan01 getLanHaninstance() {
        // 多了一个判断，可以节省空间
        if (null == lanHaninstance) {
            lanHaninstance = new SingletonLanHan01();
        }
        return lanHaninstance;
    }
}

// 测试
class SingletonLanHan01Test {
    public static void main(String[] args) {
        SingletonLanHan01 singletonLanHan01 = SingletonLanHan01.getLanHaninstance();
        SingletonLanHan01 singletonLanHan02 = SingletonLanHan01.getLanHaninstance();
        System.out.println(singletonLanHan01 == singletonLanHan02);
    }

}
