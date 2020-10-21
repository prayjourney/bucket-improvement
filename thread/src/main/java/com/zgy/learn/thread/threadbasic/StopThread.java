package com.zgy.learn.thread.threadbasic;

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
                // run之后会新建一个thread, 但是主线程还是在的叫做main,在新建的线程里，是自己的名字，而在main之中，是main线程
                System.out.println("Thread.currentThread()的name: " + Thread.currentThread().getName());
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
        // run之后会新建一个thread, 但是主线程还是在的叫做main,在新建的线程里，是自己的名字，而在main之中，是main线程
        // run之后的thread, 获取名字，要在run之中才保险，通过Thread.currentThread()方法的话
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
