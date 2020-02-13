package com.zgy.learn.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: renjiaxin
 * @Despcription: 测试BlockingQueue
 * @Date: Created in 2020/2/13 13:57
 * @Modified by:
 */
public class MyBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

        MyProducer p1 = new MyProducer(queue);
        MyProducer p2 = new MyProducer(queue);
        MyProducer p3 = new MyProducer(queue);

        MyConsumer c1 = new MyConsumer(queue);

        // 启动下面的4个线程，3个生产，1个消费
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(p1);
        executorService.execute(p2);
        executorService.execute(p3);
        executorService.execute(c1);


    }
}

/**
 * 消费者线程，一直运行，除非没有消费的对象，才会阻塞
 */
class MyConsumer implements Runnable {
    private BlockingQueue<String> queue;
    // 消费线程的状态，一直运行，如果不行，当没有可以消费的对象， 那就会自动阻塞。
    private boolean isRunning =true;

    public MyConsumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(isRunning){
                Thread.sleep(300);
                System.out.println(Thread.currentThread().getName() + ": 正在消费信息!");
                String text = queue.poll(1000, TimeUnit.MILLISECONDS);
                System.out.println("获取了数据: " + text);
                System.out.println(Thread.currentThread().getName() + "， 队列当前容量： " + queue.remainingCapacity());
            }
        } catch (InterruptedException e) {
            System.out.println("出错了！" + e.getMessage());
        }
    }
}

/**
 * 生产者线程，一直运行，除非没有剩余的位置，才会阻塞
 */
class MyProducer implements Runnable {
    private BlockingQueue<String> queue;
    // 生产线程的状态，一直运行，如果不行，当没有可以消费的对象， 那就会自动阻塞。
    private boolean isRunning =true;

    public MyProducer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(isRunning){
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + ": 正在生产信息!");
                Random r = new Random(100);
                String text = String.valueOf(r.nextInt(100));
                boolean check = queue.offer(text);
                if (check) {
                    System.out.println("ok!");
                }
                System.out.println(Thread.currentThread().getName() + "， 队列当前容量： " + queue.remainingCapacity());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
