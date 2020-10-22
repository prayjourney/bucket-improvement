package com.zgy.learn.createtype.singleton;

/**
 * @Author: renjiaxin
 * @Despcription: 单例饿汉式实现， 线程安全，但是会造成空间的浪费，不能延时加载
 * @Date: Created in 2020/2/23 11:55
 * @Modified by:
 */
public class SingletonEHan01 {
    // 饿汉式问题所在，如果没有使用到，这些空间会很浪费
    private int[] data1 = new int[1024];
    private int[] data2 = new int[1024];
    private int[] data3 = new int[1024];
    private int[] data4 = new int[1024];

    // 1. 构造器私有化
    private SingletonEHan01() {
    }

    // 2. 保证一个类只有一个实例, 立即加载该对象
    private static SingletonEHan01 eHaninstance = new SingletonEHan01();

    // 3. 提供一个全局的访问方式
    public static SingletonEHan01 geteHaninstance() {
        return eHaninstance;
    }
}

// 测试
class SingletonEHan01Test {
    public static void main(String[] args) {
        SingletonEHan01 singletonEHan01 = SingletonEHan01.geteHaninstance();
        SingletonEHan01 singletonEHan02 = SingletonEHan01.geteHaninstance();
        System.out.println(singletonEHan01 == singletonEHan02);
    }

}
