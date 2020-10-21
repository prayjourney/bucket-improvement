package com.zgy.learn.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: renjiaxin
 * @Despcription:  // compareAndSet的第一个参数，是期待值，第二个是要更新的值，期待什么呢？
 *                 // 因为我们要使用num1这个值，所以，我们不希望别人修改，而期望值，就是在我们拿到num1之后的这段时间,
 *                 // 再次去访问和比较他，是否还保持不变，所以说，这个期望值，是我们对于原来数据值的一个期望，看他是否被修改过了
 * @Date: Created in 2020/3/27 2:20
 * @Modified by:
 */
public class UseCAS001 {
    public static void main(String[] args) {
        AtomicInteger num1 = new AtomicInteger(20);

        new Thread(()->{
            // 如果没有修改，是20的话，那么就更新为2020
            System.out.println("可以更新吗？ " + (num1.compareAndSet(20, 2020) == true? "可以" : "不可以"));
            System.out.println("num1的值，现在是：" + num1.get());
        },"A---->").start();
        new Thread(()->{
            try {
                // 先睡2秒
                TimeUnit.SECONDS.sleep(2);
                // compareAndSet的第一个参数，是期待值，第二个是要更新的值，期待什么呢？
                // 因为我们要使用num1这个值，所以，我们不希望别人修改，而期望值，就是在我们拿到num1之后的这段时间,
                // 再次去访问和比较他，是否还保持不变，所以说，这个期望值，是我们对于原来数据值的一个期望，看他是否被修改过了
                System.out.println("可以更新吗？ " + (num1.compareAndSet(20, 2020) == true? "可以" : "不可以"));
                System.out.println("num1的值，现在是：" + num1.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B---->").start();
    }
}
