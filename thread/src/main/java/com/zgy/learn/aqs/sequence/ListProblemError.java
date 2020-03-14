package com.zgy.learn.aqs.sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: renjiaxin
 * @Description:
 *          1）、设计4个线程，其中两个线程每次向List集合list中添加一个元素，另外两个线程每次从集合中取出并删除一个元素。
 *          2）、删除数组中的重复项；
 * @Date: 2020-03-14 14:22
 * @Modified by:
 */
public class ListProblemError {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        MyList myList = new MyList(list);
        new Thread(()->{
            myList.add1(UUID.randomUUID().toString());
        },"A").start();
        new Thread(()->{
            myList.add2(UUID.randomUUID().toString());
        },"B").start();
        new Thread(()->{
            myList.remove1();
        },"C").start();
        new Thread(()->{
            myList.remove2();
        },"D").start();
    }
}

class MyList {
    private List<String> list;
    MyList(List<String> list){
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    Lock  lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    Condition c4 = lock.newCondition();
    public void add1(String s) {
        lock.tryLock();
        try {
            c1.await();
            if (!list.contains(s)){
                list.add(s);
            }
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void add2(String s) {
        lock.tryLock();
        try {
            c2.await();
            if (!list.contains(s)){
                list.add(s);
            }
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void remove1() {
        lock.tryLock();
        try{
            c3.await();
            while (!list.isEmpty()){
                list.remove(0);
            }
            c4.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void remove2() {
        lock.tryLock();
        try{
            c4.await();
            while (!list.isEmpty()){
                list.remove(0);
            }
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
