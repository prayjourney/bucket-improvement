package com.zgy.learn.aqs.mustkowntool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/3/8 4:27
 * @Modified by:
 */
public class UseSemaphore {
    public static void main(String[] args) {
        // 只有三个共享的资源
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    // 获取许可证
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + ": 获取了车位！");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + ": ==================》离开了车位！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放许可证
                    semaphore.release();
                }
            }, String.valueOf(i) + "线程：").start();
        }
    }
}
