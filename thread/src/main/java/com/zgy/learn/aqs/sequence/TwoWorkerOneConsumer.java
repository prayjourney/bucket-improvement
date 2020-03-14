package com.zgy.learn.aqs.sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/3/7 20:00
 * @Modified by:
 */
public class TwoWorkerOneConsumer {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        Data2 data = new Data2(list);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.workerA(UUID.randomUUID().toString());
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.workerB(UUID.randomUUID().toString());
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.consumerA();
            }
        }, "C").start();
    }
}

// 资源类 Lock
class Data2 {
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public Data2(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    List<String> list;

    public void workerA(String str) {
        lock.lock();
        try {
            // 业务，判断-> 执行-> 通知, while防止虚假唤醒
            while (list.size() >= 10 || list.contains(str)) {
                // 等待
                condition1.await();
            }
            // 唤醒，唤醒指定的人，B
            list.add(str);
            System.out.println(Thread.currentThread().getName() + "=>AAAAAAA===>插入：" +str);
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void workerB(String str) {
        lock.lock();
        try {
            // 业务，判断-> 执行-> 通知
            while (list.size() >= 10 || list.contains(str)) {
                // 等待
                condition2.await();
            }
            // 唤醒，唤醒指定的人，C
            list.add(str);
            System.out.println(Thread.currentThread().getName() + "=>BBBBBB===>插入:" +str);
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consumerA() {
        lock.lock();
        try {
            // 业务，判断-> 执行-> 通知
            while (list.size() <= 0) {
                // 等待
                condition3.await();
            }
            // 唤醒，唤醒指定的人，A
            String str = list.remove(0);
            System.out.println(Thread.currentThread().getName() + "=>CCCCCC===>消费： " +str);
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
