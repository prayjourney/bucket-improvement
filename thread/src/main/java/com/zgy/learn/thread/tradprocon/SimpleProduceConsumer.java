package com.zgy.learn.thread.tradprocon;

import java.util.ArrayList;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/3/5 2:00
 * @Modified by:
 */
public class SimpleProduceConsumer {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>(10);
        System.out.println(al.size());
        new MyProducer(al).start();
        new MyConsumer(al).start();
    }
}

class MyProducer extends Thread {
    ArrayList<String> array;

    public MyProducer(ArrayList<String> array) {
        this.array = array;
    }

    public void produce() {
        synchronized (SimpleProduceConsumer.class) {
            // 如果数组满了，生产者等待，通知消费者消费
            if (array.size() >= 10) {
                try {
                    // 生产者等待
                    System.out.println("如果数组满了，生产者等待，通知消费者消费");
                    SimpleProduceConsumer.class.wait();
                    // 通知消费者消费
                    SimpleProduceConsumer.class.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int index = array.size();
            array.add(index, "hello");
            System.out.println("生产了" + index + "号对象");
            //// 通知消费者消费
            //SimpleProduceConsumer.class.notifyAll();
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                // 模拟延时
                Thread.sleep(139);
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyConsumer extends Thread {
    ArrayList<String> array;

    public MyConsumer(ArrayList<String> array) {
        this.array = array;
    }

    public void consume() {
        synchronized (SimpleProduceConsumer.class) {
            // 如果数组空了，消费者等待，通知生产者生产
            if (array.size() == 0) {
                try {
                    System.out.println("如果数组空了，消费者等待，通知生产者生产");
                    // 消费者等待
                    SimpleProduceConsumer.class.wait();
                    // 通知生产者生产
                    SimpleProduceConsumer.class.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                int index = array.size() - 1;
                array.remove(index);
                System.out.println("消费了" + index + "号对象！");
                //// 通知生产者生产
                //SimpleProduceConsumer.class.notifyAll();
            }

        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                // 模拟延时
                Thread.sleep(100);
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

