package com.zgy.learn.aqs;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: renjiaxin
 * @Despcription: Lock的方式实现生产者消费者
 * @Date: Created in 2020/3/7 16:53
 * @Modified by:
 */
public class LockProCon {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        ProducerWithLock pwl1 = new ProducerWithLock(queue);
        ProducerWithLock pwl2 = new ProducerWithLock(queue);
        ConsumerWithLock cwl1 = new ConsumerWithLock(queue);
        new Thread(() -> {
            while (true) {
                try {
                    // 全新的sleep方法
                    TimeUnit.MILLISECONDS.sleep(200);
                    pwl1.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "小张").start();
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(120);
                    pwl2.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "王Sir").start();
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(30);
                    cwl1.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "李阳").start();
    }
}

class ProducerWithLock {
    // 容器
    private BlockingQueue<String> queue;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public ProducerWithLock(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    // 生产方法
    public void produce() {
        // 尝试获取锁
        lock.tryLock();
        try {
            // 业务处理 ，使用while破除虚假唤醒
            while (queue.size() >= 10) {
                System.out.println("盘子满了，没法继续生产，生产者等待，消费者唤醒消费！");
                condition.await(200,TimeUnit.MILLISECONDS);
            }
            // 生产
            queue.add("hello");
            System.out.println(Thread.currentThread().getName() + "：=_=生产了hello, 当前的容量是：" + queue.size());
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class ConsumerWithLock {
    // 容器
    private BlockingQueue<String> queue;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public ConsumerWithLock(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    // 消费方法
    public void consume() {
        lock.lock();
        try {
            // 业务处理，使用while破除虚假唤醒
            while (queue.size() <= 0) {
                System.out.println("盘子空了，没法继续消费，消费者等待，生产者唤醒生产！");
                condition.await(300,TimeUnit.MILLISECONDS);
            }
            // 消费
            queue.remove("hello");
            System.out.println(Thread.currentThread().getName() + "：====》消耗了：hello, 当前的容量是：" + queue.size());
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}