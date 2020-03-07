package com.zgy.learn.aqs.sequence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: renjiaxin
 * @Despcription: 按顺序执行
 * @Date: Created in 2020/3/7 19:33
 * @Modified by:
 */
public class DoWithSeq {
    public static void main(String[] args) {
        Work work = new Work();
        //要求，先执行A线程，然后执行B线程，再执行C线程，有执行A线程，循环
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                work.workFirst();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                work.workSecond();
            }
        }, "B").start();
        new Thread(() -> {
            work.workThird();
        }, "C").start();
    }
}

class Work {
    private int num = 1;
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void workFirst() {
        // 加锁
        lock.lock();
        try {
            // 业务，判断，要防止我们虚假唤醒
            while (num != 1) {
                // 等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "===>正在执行，当前的num值是：" + num);
            num = 2;
            // 精确唤醒
            // 以往的话，只有一个condition，然后一般都是condition.signalAll();
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void workSecond() {
        // 加锁
        lock.lock();
        try {
            // 业务，判断，要防止我们虚假唤醒
            while (num != 2) {
                // 等待
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "===>正在执行，当前的num值是：" + num);
            num = 3;
            // 精确唤醒
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void workThird() {
        // 加锁
        lock.lock();
        try {
            // 业务，判断，要防止我们虚假唤醒
            while (num != 3) {
                // 等待
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "===>正在执行，当前的num值是：" + num);
            // 精确唤醒
            num = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
