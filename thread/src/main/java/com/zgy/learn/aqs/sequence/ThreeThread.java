package com.zgy.learn.aqs.sequence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: renjiaxin
 * @Despcription: 让3个线程交替进行
 * @Date: Created in 2020/3/14 17:57
 * @Modified by:
 */
public class ThreeThread {
    public static void main(String[] args) {
//        Data4ThreadError d4t = new Data4ThreadError();
//        new Thread(() -> d4t.numberInfo(), "A").start();
//        new Thread(() -> d4t.numberInfo(), "B").start();
//        new Thread(() -> d4t.numberInfo(), "C").start();

        Data4ThreadOkay d4to = new Data4ThreadOkay();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                d4to.for001Thread();
            }
        }, "Thread001").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                d4to.for002Thread();
            }
        }, "Thread002").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                d4to.for003Thread();
            }
        }, "Thread003").start();
    }
}

class Data4ThreadError {
    private int number = 0;
    Lock lock = new ReentrantLock();
    // 每个condition代表着沉睡和唤醒的不同条件
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    // 这样不行， 问题在于没有释放锁，但还要唤醒别人，那就不行了啊, 不能自己去唤醒自己啊
    public void numberInfo() {
        lock.lock();
        try{

            if (number != 0) {
                c1.await();
            }
            number = 1;
            System.out.println(Thread.currentThread().getName() + "::::::》设置number为 " + number);
            c2.signal();

            if(number != 1) {
                c2.await();
            }
            number = 2;
            System.out.println(Thread.currentThread().getName() + "======》设置number为 " + number);
            c3.signal();

            if (number != 3) {
                c3.await();
            }
            number = 0;
            System.out.println(Thread.currentThread().getName() + "[[]][][]]]设置number为 " + number);
            c1.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Data4ThreadOkay {
    private int number = 1;
    Lock lock = new ReentrantLock();
    // 每个condition代表着沉睡和唤醒的不同条件
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void for001Thread() {
        lock.lock();
        try {
            while (number != 1) {
                c1.await();
            }
            number = 2;
            System.out.println(Thread.currentThread().getName() + "::::::》设置number为 " + number);
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void for002Thread() {
        lock.lock();
        try {

            while (number != 2) {
                c2.await();
            }
            number = 3;
            System.out.println(Thread.currentThread().getName() + "=====》设置number为 " + number);
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void for003Thread() {
        lock.lock();
        try {
            while (number != 3) {
                c3.await();
            }
            number = 1;
            System.out.println(Thread.currentThread().getName() + "++++++++》设置number为 " + number);
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
