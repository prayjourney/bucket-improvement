package com.zgy.learn.aqs;

/**
 * @Author: renjiaxin
 * @Despcription: BuyTickets之中专门买票，开线程专门卖
 * @Date: Created in 2020/3/7 3:16
 * @Modified by:
 */
public class BuyTickets {
    public static void main(String[] args) {
        // 将我们的资源，通过组合的方式，加载进来
        Tickets tickets = new Tickets();
        new Thread(() -> {
            while (tickets.isFlag()) {
                try {
                    Thread.sleep(100);
                    tickets.buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "小王").start();
        new Thread(() -> {
            while (tickets.isFlag()) {
                try {
                    Thread.sleep(100);
                    tickets.buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "John").start();
    }
}

/**
 * 将资源类和线程分开，然后在资源类之中，封装其属性和方法
 */
class Tickets {
    // 100张票
    private int num = 100;

    // 线程状态
    private volatile boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    // 买票
    public synchronized void buy() {
        if (num <= 0) {
            flag = false;
            System.out.println("票卖光了！");
            return;
        }
        System.out.println(Thread.currentThread().getName() + "买了第" + (num--) + "张票！");

    }
}
