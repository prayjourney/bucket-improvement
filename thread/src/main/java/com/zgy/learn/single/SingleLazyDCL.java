package com.zgy.learn.single;

/**
 * DCL单例，无线程问题，节省空间，但是还是防不住反射
 */
public class SingleLazyDCL {
    private SingleLazyDCL() {
    }

    // 此处没有立即初始化, 如果没有加volatile关键字，在创建的时候，就会有问题
    private static volatile SingleLazyDCL singleLazyDCL;

    public static SingleLazyDCL getInstance() {
        // 第一次检测
        if (singleLazyDCL == null) {
            // 第二次检测
            synchronized (SingleLazyDCL.class) {
                // 因为创建对象，不是一个原子操作
                singleLazyDCL = new SingleLazyDCL();
            }
        }
        return singleLazyDCL;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                System.out.println(getInstance().hashCode());
            }).start();
        }
    }
}

