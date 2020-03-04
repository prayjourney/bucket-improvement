package com.zgy.learn.thread;

/**
 * @Author: renjiaxin
 * @Despcription: 使用volatile原子性
 * @Date: Created in 2020/3/4 12:44
 * @Modified by:
 */
// 下面总是有问题？？？ 为何呢？？？
public class UseVolatile {

    public static void main(String[] args) {
        // unsafe
        UnsafeLong ul = new UnsafeLong();
        SafeLong sl = new SafeLong();

        for (int i = 0; i < 10 ; i++) {
            new Thread(ul,"unsafe").start();
        }

        try {
            Thread.sleep(3000);
            System.out.println("不安全方式获得：" + ul.getNum());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // safe
        for (int i = 0; i < 10 ; i++) {
            new Thread(sl,"safe").start();
        }
        try {
            Thread.sleep(3000);
            System.out.println("安全方式获得：" + sl.getNum());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 不安全的long操作
    static class UnsafeLong implements Runnable {
        private int num = 200;

        public long getNum() {
            return num;
        }

        public void increment() {
            num++;
        }


        @Override
        public void run() {
            try {
                Thread.sleep(100);
                increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    // 安全的long操作
    static class SafeLong implements Runnable {
        private volatile int num = 100;

        public long getNum() {
            return num;
        }

        public void increment() {
            num++;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
                increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


