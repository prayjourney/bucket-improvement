package com.zgy.learn.aqs.sequence;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: renjiaxin
 * @Despcription: 1个工人，2个消费者，生产和消费的方法，其实都只有1个。
 * @Date: Created in 2020/3/14 16:32
 * @Modified by:
 */
public class OneWorkTwoConsumer {
    public static void main(String[] args) {
        People people = new People();
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(70);
                    people.work();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "工人").start();
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                    people.buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "【消费者A】").start();
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    people.buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "【消费者B】").start();
    }
}

class People {
    private int cakeNum = 0;
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();

    public int getCakeNum() {
        return cakeNum;
    }

    // 生产
    public void work() {
        lock.lock();
        try {
            while (cakeNum >= 10) {
                c1.await();
            }
            cakeNum += 1;
            System.out.println(Thread.currentThread().getName() + "===>: 生产了 1 个蛋糕！当前cakeNum: " + getCakeNum());
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 消费
    public void buy() {
        lock.lock();
        try {
            while (cakeNum == 0) {
                c2.await();
            }
            cakeNum -= 1;
            System.out.println(Thread.currentThread().getName() + ": 消费了 1 个蛋糕！当前cakeNum: " + getCakeNum());
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
