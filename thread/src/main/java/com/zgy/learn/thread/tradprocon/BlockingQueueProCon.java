package com.zgy.learn.thread.tradprocon;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: renjiaxin
 * @Description: 使用BlockingQueue來完成生产者消费者的功能
 * @Date: 2020-03-06 01:39
 * @Modified by:
 */
public class BlockingQueueProCon {
    // 容器
    static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
    // 使用相同的锁
    static Object objectLock = new Object();

    public static void main(String[] args) {
        ProProducer pp1 = new ProProducer(queue, objectLock);
        ProProducer pp2 = new ProProducer(queue, objectLock);
        ProConsumer pc1 = new ProConsumer(queue, objectLock);
        // 1个消费者,2个生产者
        Thread producer1 = new Thread(pp1);
        Thread producer2 = new Thread(pp2);
        Thread consumer1 = new Thread(pc1);
        producer1.start();
        //producer2.start();
        consumer1.start();
    }
}


class ProProducer implements Runnable {
    BlockingQueue<String> queue;
    Object objectLock;

    ProProducer(BlockingQueue<String> queue, Object objectLock) {
        this.queue = queue;
        this.objectLock = objectLock;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 生产的方法
     *
     * @throws InterruptedException
     */
    public synchronized void produce() throws InterruptedException {
        synchronized (objectLock){
            if (queue.size() >= 10) {
                // 生产者生产导致容器满了, 那么生产者等待, 唤醒消费者消费
                System.out.println("生产者生产导致容器满了, 那么生产者等待, 唤醒消费者消费");
                objectLock.wait();
            }
            queue.put("hello");
            System.out.println("生产者: " + Thread.currentThread().getName() + ": 完成了hello的插入, 在"
                    + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME) + ", 目前的容量是: " +
                    queue.size());
            // 唤醒消费者消费
            objectLock.notifyAll();
        }
    }

}

class ProConsumer implements Runnable {
    BlockingQueue<String> queue;
    Object objectLock;

    ProConsumer(BlockingQueue<String> queue, Object objectLock) {
        this.queue = queue;
        this.objectLock = objectLock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(180);
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费的方法
     *
     * @throws InterruptedException
     */
    public synchronized void consume() throws InterruptedException {
        synchronized (objectLock){
            if (queue.size() <= 0) {
                // 消费者消费到容器之中没有对象, 那么消费者等待, 唤醒生产者
                System.out.println("消费者消费到容器之中没有对象, 那么消费者等待, 唤醒生产者");
                objectLock.wait();
            }
            String msg = queue.take();
            System.out.println("消费者: " + Thread.currentThread().getName() + ": 完成了" + msg + "的消费, 在:"
                    + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME) + ", 目前的容量是: " +
                    queue.size());
            // 唤醒消生产者生产
            objectLock.notifyAll();
        }

    }
}