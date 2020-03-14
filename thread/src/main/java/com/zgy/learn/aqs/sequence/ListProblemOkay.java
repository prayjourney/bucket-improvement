package com.zgy.learn.aqs.sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: renjiaxin
 * @Description: 1）、设计4个线程，其中两个线程每次向List集合list中添加一个元素，另外两个线程每次从集合中取出并删除一个元素。
 * 2）、删除数组中的重复项；
 * @Date: 2020-03-14 14:22
 * @Modified by:
 */
public class ListProblemOkay {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        MyList2 myList2 = new MyList2(list);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myList2.add1(UUID.randomUUID().toString());
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myList2.add2(UUID.randomUUID().toString());
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myList2.remove1();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myList2.remove2();
            }
        }, "D").start();
    }
}

class MyList2 {
    private List<String> list;

    MyList2(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    Condition c4 = lock.newCondition();

    public void add1(String s) {
        lock.lock();
        try {
            if (!list.contains(s)) {
                list.add(s);
                System.out.println(Thread.currentThread().getName() + ": 为list添加了 " + s);
            }
            c1.await();
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void add2(String s) {
        lock.lock();
        try {
            if (!list.contains(s)) {
                list.add(s);
                System.out.println(Thread.currentThread().getName() + ": 为list添加了 " + s);
            }
            c2.await();
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void remove1() {
        lock.lock();
        try {
            if (!list.isEmpty()) {
                String str = list.remove(0);
                System.out.println(Thread.currentThread().getName() + ": 消費了 " + str);
            }
            c3.await();
            c4.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void remove2() {
        lock.lock();
        try {
            if (!list.isEmpty()) {
                String str = list.remove(0);
                System.out.println(Thread.currentThread().getName() + ": 消費了 " + str);
            }
            c4.await();
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
