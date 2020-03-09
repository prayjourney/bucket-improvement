package com.zgy.learn.aqs.usevolatile;

import java.util.concurrent.TimeUnit;

/**
 * @Author: renjiaxin
 * @Despcription: Volatile可见性
 * @Date: Created in 2020/3/9 23:05
 * @Modified by:
 */
public class VolatileSee {
    // 共享变量
    // private static long num = 0L;
    private volatile static long num = 0L;

    public static void main(String[] args) {
        new Thread(() -> {
            while (num == 0) {
                // 一直执行
                System.out.println(">>>");
            }
        }, "A").start();

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 没有volatile修饰num,那A：thread就会一直执行，如果volatile num, 那么修改后就立马停止
        num = 1L;
    }
}
