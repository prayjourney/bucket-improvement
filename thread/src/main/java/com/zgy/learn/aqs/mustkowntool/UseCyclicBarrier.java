package com.zgy.learn.aqs.mustkowntool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: renjiaxin
 * @Despcription: 集齐7颗龙珠召唤神龙
 * @Date: Created in 2020/3/8 4:13
 * @Modified by:
 */
public class UseCyclicBarrier {
    public static void main(String[] args) {
        // 召唤龙珠的线程, 只有等到有7个线程，才会执行runnable之中的方法！
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙成功！");
        });
        for (int i = 1; i <= 7; i++) {
            final int temp = i;
            // lambda能操作到 i 吗
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "收集" + temp + " 个龙珠");
                try {
                    cyclicBarrier.await(); // 达不到条件的时候，那就等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
