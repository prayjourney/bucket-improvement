package com.zgy.learn.thread.tranditionmutil;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: renjiaxin
 * @Despcription: 测试线程安全的list:CopyOnWriteArrayList和不安全的list:ArrayList
 * @Date: Created in 2020/3/2 22:34
 * @Modified by:
 */
public class OperateList {
    public static void main(String[] args) {

        CopyOnWriteArrayList<String> cp = new CopyOnWriteArrayList<>();
        TestCopyOnWriteArrayList copy = new TestCopyOnWriteArrayList(cp);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(copy);
            t.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("CopyOnWriteArrayList cp的size: " + cp.size());

        // 公共的ArrayList对象, 下面的操作是不安全的
        ArrayList<String> list = new ArrayList<>();
        new OperateList().testArrayList(list);
    }

    // ArrayList线程不安全
    public void testArrayList(ArrayList list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(10);
                    list.add("hello");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("经过100个多线程操作之后, arrayList的大小是：" + list.size());
    }


}

// CopyOnWriteArrayList线程安全
class TestCopyOnWriteArrayList implements Runnable {
    private CopyOnWriteArrayList coList;

    public TestCopyOnWriteArrayList(CopyOnWriteArrayList coList) {
        this.coList = coList;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            coList.add("hello, world!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


