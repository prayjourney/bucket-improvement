package com.zgy.learn.feature;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/3/26 1:04
 * @Modified by:
 */
public class UseFinal {
    private final int NUM = 100;
    private final static Integer MONEYALL = 200;
    Lock lock = new ReentrantLock();
    private int myMoney;

    public UseFinal(int myMoney) {
        this.myMoney = myMoney;
    }

    public int getMyMoney() {
        return myMoney;
    }

    public void setMyMoney(int myMoney) {
        this.myMoney = myMoney;
    }

    public static void main(String[] args) {
        UseFinal uf = new UseFinal(150);
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    uf.shopping();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "小明").start();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    uf.shopping();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "===》小红").start();
    }

    public void shopping() {
        lock.lock();
        try {
            if (getMyMoney() > MONEYALL) {
                System.out.println(Thread.currentThread().getName() + ": 你不可能有那么多的钱，请如数上缴国库！！！");
                return;
            }
            if (getMyMoney() < 0) {
                System.out.println(Thread.currentThread().getName() + ": 当前没有钱了！");
                return;
            }
            System.out.println(Thread.currentThread().getName() + ": 想要花钱，当前的钱是: " + getMyMoney());
            Random random = new Random();
            Integer i = random.nextInt(30);
            myMoney -= i;
            System.out.println(Thread.currentThread().getName() + ": 花了" + i + "元钱，当前的钱是: " + getMyMoney());
            System.out.println(Thread.currentThread().getName() + ": 今天花了钱，那么就要做仰卧起坐" + NUM + "个！");
        } finally {
            lock.unlock();
        }


    }
}
