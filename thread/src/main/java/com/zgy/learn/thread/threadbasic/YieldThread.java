package com.zgy.learn.thread.threadbasic;

/**
 * @Author: renjiaxin
 * @Despcription: yield和优先级有关系，礼让给比自己高等级的线程，低的不让，不释放锁，转入就绪状态
 * @Date: Created in 2020/3/1 20:22
 * @Modified by:
 */
public class YieldThread implements Runnable {
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("hello " + name + ", 开始线程！");
        Thread.yield();
        System.out.println("hello " + name + ", 结束线程！");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new YieldThread(), "t1");
        Thread t2 = new Thread(new YieldThread(), "t2");
        Thread t3 = new Thread(new YieldThread(), "t3");
        Thread t4 = new Thread(new YieldThread(), "t4");
        t1.setPriority(3);
        t3.setPriority(8);
        t4.setPriority(6);

        System.out.println("t1的优先级" + t1.getPriority());
        System.out.println("t2的优先级" + t2.getPriority());
        System.out.println("t3的优先级" + t3.getPriority());
        System.out.println("t4的优先级" + t4.getPriority());

        // 运行
        t1.start();
        t2.start();

        t3.start();
        t4.start();

    }
}
