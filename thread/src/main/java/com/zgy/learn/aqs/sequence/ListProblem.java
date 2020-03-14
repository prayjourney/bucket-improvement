package com.zgy.learn.aqs.sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: renjiaxin
 * @Despcription: *          1）、设计4个线程，其中两个线程每次向List集合list中添加一个元素，另外两个线程每次从集合中取出并删除一个元素。
 * *          2）、删除数组中的重复项；
 * @Date: Created in 2020/3/14 17:12
 * @Modified by:
 */
public class ListProblem {
    public static void main(String[] args) {
        // list容量为10
        List<String> list = new ArrayList<>(10);
        Worker4Element w4e = new Worker4Element(list);
        new Thread(()->{
            while(true){
                try {
                    TimeUnit.MILLISECONDS.sleep(90);
                    w4e.addElement(UUID.randomUUID().toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者A").start();
        new Thread(()->{
            while(true){
                try {
                    TimeUnit.MILLISECONDS.sleep(110);
                    w4e.addElement(UUID.randomUUID().toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者B").start();
        new Thread(()->{
            while(true){
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                    w4e.removeElement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"中国消费者").start();
        new Thread(()->{
            while(true){
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                    w4e.removeElement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"日本消费者").start();
    }


    static class Worker4Element {
        private List<String> list;
        private Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        public Worker4Element(List<String> list) {
            this.list = list;
        }

        // 生产元素加入
        public void addElement(String str) {
            lock.lock();
            try {
                while (list.size() >= 10 && !list.contains(str)) {
                    c1.await();
                }
                list.add(str);
                System.out.println(Thread.currentThread().getName() + "===》 生产了: " + str
                        + ", 当前有：" + list.size() + "个。");
                c2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        // 消费元素取出
        public void removeElement() {
            lock.lock();
            try {
                while(list.size() ==0){
                    c2.await();
                }
                String str = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "===》 消费了: " + str
                        + ", 当前有：" + list.size() + "个。");
                c1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
