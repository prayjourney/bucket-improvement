package com.zgy.learn.thread.tradmulti;

/**
 * @Author: renjiaxin
 * @Despcription: 使用volatile原子性
 * @Date: Created in 2020/3/4 12:44
 * @Modified by:
 */
// 测试原子性
class TestAtomicVolatile {
    public volatile long inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final TestAtomicVolatile test = new TestAtomicVolatile();
        for (int i = 0; i < 5; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        test.increase();
                    }
                }

                ;
            }.start();
        }


        // 保证前面的线程都执行完
        // while (Thread.activeCount() > 1)
        //       Thread.yield();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test.inc);
    }
}

// 测试透明性
class TestTransparentVolatile extends Thread {
    // 没有volatile关键字，那就会一直执行
    volatile boolean flag = false;
    int i = 0;

    public void run() {
        while (!flag) {
            i++;
        }
    }

    public static void main(String[] args) throws Exception {
        TestTransparentVolatile vt = new TestTransparentVolatile();
        vt.start();
        Thread.sleep(2000);
        vt.flag = true;
        System.out.println("stope：" + vt.i);
    }
}

// 下面总是有问题？？？ 为何呢？？？
public class UseVolatile {

    public static void main(String[] args) {
        // unsafe
        UnsafeLong ul = new UnsafeLong();
        SafeLong sl = new SafeLong();

        for (int i = 0; i < 10; i++) {
            new Thread(ul, "unsafe").start();
        }

        try {
            Thread.sleep(3000);
            System.out.println("不安全方式获得：" + ul.getNum());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // safe
        for (int i = 0; i < 10; i++) {
            new Thread(sl, "safe").start();
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


