package com.zgy.learn.aqs.mustkowntool;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: renjiaxin
 * @Despcription: CountDownLatch就是个减法计数器，等待所有的线程完毕之后，再执行下面的操作
 * @Date: Created in 2020/3/8 3:53
 * @Modified by:
 */
public class UseCountDownLatch {
    static class Student {
        public void goHome() {
            System.out.println(Thread.currentThread().getName() + ": 我要回家了！");
        }
    }

    // 功能， 有5个学生，回家之后，才能关闭教室的门！
    public static void main(String[] args) throws InterruptedException {
        // 计数器表示计数的数量
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                new Student().goHome();
                latch.countDown();
            }, ("学生" + i)).start();
        }
        // 保证关门是最后的一个动作！
        latch.await(); // 这个放开，才是会在最后一个执行
        System.out.println("警告：教室门要关闭了！！！");
    }
}
