package com.zgy.learn.thread.tradprocon;

import java.util.ArrayList;

/**
 * @Author: renjiaxin
 * @Despcription: 管程法，解决生产者消费者问题，管程法用的是缓冲区的方式， PC produce&Consume
 * @Date: Created in 2020/3/4 16:26
 * @Modified by:
 */
// 需要生产者，消费者，产品，缓冲区， 问题，对盘子操作呢，还是对生产者和消费者，就是说在哪儿去唤醒和沉睡
public class GuanchengfaPC {
    public static void main(String[] args) {
        ChickenContainer ch = new ChickenContainer();
        Producer p1 = new Producer(ch);
        Producer p2 = new Producer(ch);
        Consumer c1 = new Consumer(ch);
        new Thread(c1).start();
        p1.start();
        p2.start();
    }
}

// 生产者
class Producer extends Thread {
    ChickenContainer container;
    private int id = 1;

    public Producer(ChickenContainer container) {
        this.container = container;
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

    public void produce() {
        Chicken chicken = new Chicken(id);
        container.plate.add(chicken);
        System.out.println(Thread.currentThread().getName() + "炸好了 " + id + "号炸鸡！");
        id++;
    }
}

// 消费者
class Consumer implements Runnable {
    ChickenContainer container;

    public Consumer(ChickenContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Chicken consume() {
        Chicken chicken = container.pop();
        System.out.println(Thread.currentThread().getName() + "吃了 " + chicken.getId() + "号炸鸡！");
        return chicken;
    }

}

// 产品，此处用鸡来表示
class Chicken {
    private int id;

    public Chicken(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "id=" + id +
                '}';
    }
}

// 用来装鸡的容器，可以用队列代替
class ChickenContainer {
    ArrayList<Chicken> plate = new ArrayList(10);

    // 往盘子里面装鸡儿
    public synchronized void add(Chicken chicken) {
        if (plate.size() >= 10) {
            System.out.println("现在盘子的容量为10，装不下了，请及时消费！");
            try {
                plate.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        plate.notifyAll();
        plate.add(chicken);
    }

    // 从盘子里面拿鸡儿
    public synchronized Chicken pop() {
        if (plate.size() <= 0) {
            System.out.println("现在盘子的容量为0，请快生产炸鸡吧！");
            try {
                plate.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        plate.notifyAll();
        return plate.remove(0);
    }
}
