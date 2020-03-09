package com.zgy.learn.aqs.usevolatile;

/**
 * @Author: renjiaxin
 * @Despcription: 按理来说是20000，但不是，不保证原子性
 * @Date: Created in 2020/3/9 23:19
 * @Modified by:
 */
public class VolatileNonAtomic {
    // volatile 不保证原子性
    private volatile static int num = 0;

    // ++的一个操作，不是原子性
    public static void add() {
        num++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            // 新线程
            new Thread(() -> {
                for (int m = 0; m < 1000; m++) {
                    add();
                }
            }).start();

        }

        // 只有GC和main线程，那么一定是执行完了
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("num：" + num);
    }


}
