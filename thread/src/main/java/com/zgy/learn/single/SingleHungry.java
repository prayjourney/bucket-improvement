package com.zgy.learn.single;

/**
 * 饿汉式单例，没有多线程的问题，但是如果存在多个变量，会有空间浪费的问题，如下的byte数组
 */
public class SingleHungry {
    private SingleHungry() {
    }

    // 存在空间浪费的问题
    private byte[] b1 = new byte[1024];
    private byte[] b2 = new byte[1024];
    private byte[] b3 = new byte[1024];

    private static SingleHungry a = new SingleHungry();

    public static SingleHungry getInstance() {
        return a;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                System.out.println(getInstance().hashCode());
            }).start();
        }
    }
}
