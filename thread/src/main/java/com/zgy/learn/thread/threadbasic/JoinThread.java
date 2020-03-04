package com.zgy.learn.thread.threadbasic;

/**
 * @Author: renjiaxin
 * @Despcription: 插队Thread, join方法，会释放锁，然后进入阻塞状态
 * @Date: Created in 2020/3/1 20:03
 * @Modified by:
 */
public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        // 当前线程就是thread1
                        Thread.sleep(100);
                        System.out.println("我是thread1, 第 " + i + " 次运行");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "thread1");
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i == 6) {
                    try {
                        // thread1 就在这儿插队，牛逼不牛逼！
                        System.out.println("thread2被打断！");
                        thread1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("thread2...");

            }
        }, "thread2");

        // 启动线程
        thread1.start();
        thread2.start();
    }
}
