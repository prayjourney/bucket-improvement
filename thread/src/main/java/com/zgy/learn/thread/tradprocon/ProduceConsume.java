package com.zgy.learn.thread.tradprocon;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class ProduceConsume {
    // 盘子的总容量
    private static Integer capacity;

    // 盘子当前的容量
    private static Integer currentCapacity;
    // 定义一个公共的锁
    public Object lockObj = new Object();

    // 定义一个公共的时间格式化标准
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd HH:mm:ss");

    public static void main(String[] args) {
        // 开启生产和消费的过程
        ProduceConsume pc = new ProduceConsume();

        // 盘子总容量为100
        ProduceConsume.capacity = 100;

        // 当前容量为66
        ProduceConsume.currentCapacity = 67;

        //创建一个消费者线程, 一次消费的容量为22
        Consumer consumer = pc.new Consumer("奶茶妹妹", 22);
        Thread consumeThread = new Thread(consumer);

        //创建一个生产者线程, 一次生产的容量为14
        Producer producer = pc.new Producer("张三", 14);
        Thread productThread = new Thread(producer);

        // 开启消费和生产的线程
        consumeThread.start();
        productThread.start();

    }

    /**
     * 生产者
     */
    @Data
    @AllArgsConstructor
    class Producer implements Runnable {
        // 生产者
        private String name;
        // 每次生产的数量
        private int productNo;

        @Override
        public void run() {
            // 条件允许则一直生产, 条件控制在每一次基本的生产过程之中
            // while (currentCapacity + capacity <= 100) {
            while (true) {
                try {
                    // 控制生产的速度
                    Thread.sleep(1000);
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // 一次基本的生产过程
        // public synchronized void produce() throws InterruptedException {
        public void produce() throws InterruptedException {
            // 生产前, 需要先拿到公共锁
            synchronized (lockObj) {
                // 不能大于盘子的容积
                if (currentCapacity + productNo >= 100) {
                    System.out.println("盘子已满, 装不下了, 不能再生产了...");

                    /* 使用哪个对象锁了, 就需要用哪个对象来解开锁, 此处用this.wait(), wait()都不是使用lockObj,
                     * this.wait()用的是this对象, wait()用的是类对象?
                     * 反正不是同一个对象
                     * 使用锁的时候, 尤其有交互, 必须保证是同一个对象!!!
                     */

                    // 阻塞===>生产线程
                    lockObj.wait();
                    // 唤醒消费线程
                    lockObj.notifyAll();
                    System.out.println(Thread.currentThread().getState());

                } else {
                    currentCapacity += productNo;
                    String time = timeFormatter.format(LocalDateTime.now());
                    String productInfo = String.format("生产者: %s 于 %s 进行了一次生产, 目前盘子容量为 %d. ",
                            getName(), time, ProduceConsume.currentCapacity);
                    System.out.println(productInfo);
                }

            }
        }
    }

    /**
     * 消费者
     */
    @Data
    @AllArgsConstructor
    class Consumer implements Runnable {
        // 消费者
        private String name;
        // 每次消耗的数量
        private int consumeNo;

        @Override
        public void run() {
            // 条件允许则一直消费, 条件控制在每一次基本的消费过程之中
            // while (currentCapacity - consumeNo > 0) {
            while (true) {
                try {
                    // 控制消费的速度
                    Thread.sleep(300);
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        // 一次基本的消耗过程
        // public synchronized void consume() throws InterruptedException {
        public void consume() throws InterruptedException {
            // 消费前, 需要先拿到公共锁
            synchronized (lockObj) {
                if (currentCapacity - consumeNo < 0) {
                    System.out.println("盘子已空, 无可消费物品, 不能再消费了...");

                    /* 使用哪个对象锁了, 就需要用哪个对象来解开锁, 此处用this.wait(), wait()都不是使用lockObj,
                     * this.wait()用的是this对象, wait()用的是类对象?
                     * 反正不是同一个对象
                     * 使用锁的时候, 尤其有交互, 必须保证是同一个对象!!!
                     */

                    // 阻塞当前===>消费线程
                    lockObj.wait();
                    // 唤起生产线程
                    lockObj.notifyAll();
                } else {
                    currentCapacity -= consumeNo;
                    String time = timeFormatter.format(LocalDateTime.now());
                    String productInfo = String.format("消费者: %s 于 %s 进行了一次消费, 目前盘子容量为 %d. ",
                            getName(), time, ProduceConsume.currentCapacity);
                    System.out.println(productInfo);
                }
            }
        }
    }
}
