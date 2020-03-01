package com.zgy.learn.thread;

/**
 * @Author: renjiaxin
 * @Despcription: 停止线程，使用一个标志位的方式
 * @Date: Created in 2020/3/1 15:12
 * @Modified by:
 */
public class StopThread implements Runnable {
    // 标志位
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(1000);
                System.out.println("hello my world ! ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 设置标志位，为false， 则会让线程停下来，停下来的时机，还是由JVM来决定的
    public void stop() {
        flag = false;
    }

    public static void main(String[] args) {
        StopThread st = new StopThread();
        Thread thread = new Thread(st);
        thread.start();
        System.out.println("thread的name: " + thread.getName());
        System.out.println("Thread.currentThread()的name: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("准备停止thread线程");
        st.stop();
        while(thread.getState()!= Thread.State.TERMINATED){
            System.out.println("thread线程的状态：" + thread.getState());
        }

    }

}
