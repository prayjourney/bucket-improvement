package com.zgy.learn.thread;

/**
 * @Author: renjiaxin
 * @Despcription: 同步方法，来买票，此时，只有一个类操作
 * 启示:  1.不应该给run方法加synchronized
 *        2. 同步的应该是具体的操作方法，或者是共享的资源，如下面的buy或者tickets
 *        3. 如果要多次循环，应该在run方法之中去循环，此处可以去停顿，而在一次正常的操作之中，最好别去停顿
 *        4. 如果要多次循环，需要有一个停止的标志
 * @Date: Created in 2020/3/1 22:49
 * @Modified by:
 */

// 使用同步方法，对类对象加锁
public class BuyTicketsSyncMethod implements Runnable {
    private static Integer tickets = 100;
    private boolean flag = true;

    // 不应该给run方法加synchronized
    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(100);
                buyTicket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void buyTicket() {
        if (tickets <= 0) {
            System.out.println("车票不足！");
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + ": 抢到了第 " + tickets-- + " 张票！");
    }

    public static void main(String[] args) {
        BuyTicketsSyncMethod buyTickets = new BuyTicketsSyncMethod();
        Thread t1 = new Thread(buyTickets, "张三");
        Thread t2 = new Thread(buyTickets, "李四");
        Thread t3 = new Thread(buyTickets, "王五");
        t1.start();
        t2.start();
        t3.start();
    }

}

// 使用同步块，对共享变量加锁
class BuyTicketSyncBlock {
    public static void main(String[] args) {
        TicketSeller seller = new TicketSeller();
        new Thread(seller, "苦逼的我===: ").start();
        new Thread(seller, "牛逼的你===: ").start();
        new Thread(seller, "可恶的黄牛党===: ").start();
    }
}

class TicketSeller implements Runnable {
    // 票
    private Integer tickerNums = 10;
    // 外部停止方式
    boolean flag = true;

    @Override
    public void run() {
        // 买票
        while (flag) {
            try {
                // 模拟延时
                Thread.sleep(100);
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void buy() throws InterruptedException {
        synchronized (tickerNums) {
            // 判断是否有票
            if (tickerNums <= 0) {
                flag = false;
                return;
            }

            // 模拟延时
            //Thread.sleep(10); // 会产生问题， 我们的操作之中，不应该去停顿， 而在线程跑的时候，去停顿

            // 买票
            System.out.println(Thread.currentThread().getName() + "抢到了第 " + tickerNums-- + " 张票！");
        }
    }

}