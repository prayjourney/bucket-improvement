package com.zgy.learn.thread.threadbasic;

/**
 * @Author: renjiaxin
 * @Despcription: 观察线程的状态
 * @Date: Created in 2020/3/1 13:45
 * @Modified by:
 */
public class WatchState {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello world");
        });

        // 观察状态
        Thread.State state = t.getState();
        System.out.println("当前的线程状态 ： " + state);

        //
        t.start();
        state = t.getState();
        System.out.println("当前的线程状态 ： " + state);

        while (state != Thread.State.TERMINATED) {
            Thread.sleep(300);
            state = t.getState();
            System.out.println("当前的线程状态 ： " + state);
        }

        state = t.getState();
        System.out.println("当前的线程状态 ： " + state);
    }
}
//输出信息
//当前的线程状态 ： NEW
//当前的线程状态 ： RUNNABLE
//当前的线程状态 ： TIMED_WAITING
//当前的线程状态 ： TIMED_WAITING
//当前的线程状态 ： TIMED_WAITING
//hello world
//当前的线程状态 ： TERMINATED
//当前的线程状态 ： TERMINATED