package com.zgy.learn.single;

/**
 * 懒汉单例，使用时候再去加载，但是，存在多线程的问题，如果没有DCL检测，那就不能使用
 */
public class SingleLazy {

    private SingleLazy() {
    }

    // 此处没有立即初始化
    private static SingleLazy singleLazy;

    public static SingleLazy getInstance() {
        // 这样是有问题的
        if (singleLazy == null) {
            singleLazy = new SingleLazy();
        }
        return singleLazy;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                System.out.println(getInstance().hashCode());
            }).start();
        }
    }
}
