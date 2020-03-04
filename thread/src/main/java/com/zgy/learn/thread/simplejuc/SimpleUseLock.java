package com.zgy.learn.thread.simplejuc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: renjiaxin
 * @Despcription: 简单使用Lock锁
 * @Date: Created in 2020/3/4 15:30
 * @Modified by:
 */
public class SimpleUseLock {
    public static void main(String[] args) {
        Seller seller = new Seller();
        for (int i = 0; i < 3; i++) {
            new Thread(seller, "线程" + i).start();
        }
    }
}

class Seller implements Runnable {
    // 10张票
    private int num = 10;
    final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        if (num <= 0) {
            return;
        } else {
            while (num > 0) {
                try {
                    Thread.sleep(1000);
                    buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    // 这个还是单次买票需要做的事情
    public void buy() {
        lock.lock();
        try {
            if (num < 0) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + ": 获得第 " + num-- + "张票！");
        } finally {
            lock.unlock();
        }
    }
}
