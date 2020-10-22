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
 * 多线程问题死锁,解决的方法
 * 1.使用jconsole
 * 2.使用线程快照在idea之中
 * 3.使用jps+jstack的信息
 * 4.使用jps+ jcmd pid Thread.print, 可以打印出来信息
 * https://blog.csdn.net/u010647035/article/details/79769177
 * https://www.cnblogs.com/wy697495/p/9757982.html
 * https://blog.csdn.net/wang0112233/article/details/83749927
 * https://blog.csdn.net/sxhong/article/details/78603671
 * https://blog.csdn.net/u010647035/article/details/79770534
 */
public class BlockingQueueProCon {
    // 容器, 容量为10
    static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
    // 使用相同的锁
    static Object objectLock = new Object();

    public static void main(String[] args) {
        ProProducer pp1 = new ProProducer(queue, objectLock);
        ProProducer pp2 = new ProProducer(queue, objectLock);
        ProConsumer pc1 = new ProConsumer(queue, objectLock);
        // 1个消费者,2个生产者
        Thread producer1 = new Thread(pp1, "生产者1");
        Thread producer2 = new Thread(pp2, "生产者2");
        Thread consumer1 = new Thread(pc1, "消费者");
        producer1.start();
        producer2.start();
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
    public void produce() throws InterruptedException {
        synchronized (objectLock) {
            // 这儿应该使用while, 如果是if, 可能会有线程虚假唤醒的问题
            // if (queue.size() >= 10) {
            while (queue.size() >= 10) {
                // 生产者生产导致容器满了, 那么生产者等待, 唤醒消费者消费
                System.out.println("生产者生产导致容器满了, 那么生产者等待, 唤醒消费者消费");
                objectLock.wait(1000);
                // 唤醒消费者消费
                objectLock.notifyAll();
            }
            //queue.put("hello"); // 可以阻塞的方法
            queue.add("hello");
            System.out.println("生产者: " + Thread.currentThread().getName() + ": 完成了hello的插入, 在"
                    + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME) + ", 目前的容量是: " +
                    queue.size());
            // 唤醒消费者消费
            //objectLock.notifyAll();//wait和notify分开,就会产生超标的作用,然后退化成单线程的操作
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
    public void consume() throws InterruptedException {
        synchronized (objectLock) {
            // 这儿应该使用while, 如果是if, 可能会有线程虚假唤醒的问题
            //if (queue.size() <= 0) {
            while (queue.size() <= 0) {
                // 消费者消费到容器之中没有对象, 那么消费者等待, 唤醒生产者
                System.out.println("消费者消费到容器之中没有对象, 那么消费者等待, 唤醒生产者");
                objectLock.wait(1000);
                // 唤醒消生产者生产
                objectLock.notifyAll();
            }
            // String msg = queue.take();//可以阻塞的方法
            String msg = queue.remove();
            System.out.println("消费者: " + Thread.currentThread().getName() + ": 完成了" + msg + "的消费, 在:"
                    + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME) + ", 目前的容量是: " +
                    queue.size());
            // 唤醒消生产者生产
            //objectLock.notifyAll();//wait和notify分开,就会产生超标的作用,然后退化成单线程的操作
        }

    }
}