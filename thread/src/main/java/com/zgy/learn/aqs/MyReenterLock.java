package com.zgy.learn.aqs;

import java.util.concurrent.TimeUnit;

/**
 * @Author: renjiaxin
 * @Despcription: 可重入锁，synchronized和Lock都是可重入锁，可重入锁可以一定程度上减缓死锁，以synchronized为例子
 * @Date: Created in 2020/3/11 2:41
 * @Modified by:
 */
public class MyReenterLock {
    public static void main(String[] args) throws InterruptedException {
        new MyReenterLock().testA();

    }

    // 也叫递归锁，其实就是，拿到了外面的锁，里面的锁自动拿到
    synchronized void testA() throws InterruptedException {
        System.out.println("hello 我是A");
        testB();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("What The FUCK!");
    }

    synchronized void testB() {
        System.out.println("hello 我是B");
    }
}