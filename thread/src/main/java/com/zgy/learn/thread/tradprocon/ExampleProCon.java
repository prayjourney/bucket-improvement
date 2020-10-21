package com.zgy.learn.thread.tradprocon;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueue之中的例子, 消费和生产的方法没有实现其实
 */
public class ExampleProCon {
    public static void main(String[] args) {
        BlockingQueue q = new ArrayBlockingQueue(10);
        Producer1 p = new Producer1(q);
        Consumer1 c1 = new Consumer1(q);
        Consumer1 c2 = new Consumer1(q);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }

}

class Producer1 implements Runnable {
    private final BlockingQueue queue;

    Producer1(BlockingQueue q) {
        queue = q;
    }

    @Override
    public void run() {
        try {
            while (true) {
                queue.put(produce());
            }
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
    }

    Object produce() {
        // handle
        return new Object();
    }
}

class Consumer1 implements Runnable {
    private final BlockingQueue queue;

    Consumer1(BlockingQueue q) {
        queue = q;
    }

    @Override
    public void run() {
        try {
            while (true) {
                consume(queue.take());
            }
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
    }

    void consume(Object x) {
        // handle
    }
}
 