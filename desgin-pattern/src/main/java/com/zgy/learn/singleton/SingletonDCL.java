package com.zgy.learn.singleton;

/**
 * @Author: renjiaxin
 * @Despcription: 双重检测DCL实现， 线程安全，能延时加载，线程安全，效率比懒汉好一点
 * @Date: Created in 2020/2/23 11:55
 * @Modified by:
 */
public class SingletonDCL {
    // 1. 构造器私有化
    private SingletonDCL() {
    }

    // 2. 保证一个类只有一个实例, 不去立即加载该对象, 使用volatile, 防止指令重排，导致在极端情况下，创建多个实例
    private static volatile SingletonDCL dclInstance;

    // 3. 提供一个全局的访问方式, 由于多线程问题，需要使用到synchronized关键字，效率较低
    public static synchronized SingletonDCL getDCLinstance() {
        // 锁的细化，需要竞争类锁，检测两次
        if (null == dclInstance) {
            synchronized (SingletonDCL.class) {
                if (null == dclInstance) {
                    dclInstance = new SingletonDCL();
                }
            }
        }
        return dclInstance;
    }
}

// 测试
class SingletonDCLTest {
    public static void main(String[] args) {
        SingletonDCL dcLinstance1 = SingletonDCL.getDCLinstance();
        SingletonDCL dcLinstance2 = SingletonDCL.getDCLinstance();
        System.out.println(dcLinstance1 == dcLinstance2);
    }

}
