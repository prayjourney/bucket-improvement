package com.zgy.learn.aqs.sequence;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * // 评测题目: 公司有一位HR和A,B两位面试官，
 * // HR每隔1~10秒会获得一份简历，直到获取简历总数量达到100份就不再获得。
 * // 面试官一旦面试完就会从HR那边获取简历，直到所有简历都面试反馈完成。
 * // 面试官A处理一份简历需要3秒，B处理一份简历需要5秒。
 * // AB面试官在处理完简历后需要给HR反馈（随机通过或者不通过）。
 * // 请编码模拟本系统
 */
public class TestInterview {
    public static void main(String[] args) {
        Resume resume = new Resume();
        new Thread(() -> {
            // 最多100份简历
            for (int i = 0; i < 100; i++) {
                try {
                    Random random = new Random();
                    int time = random.nextInt(10);
                    TimeUnit.MILLISECONDS.sleep(time);
                    resume.collectResume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "HR").start();
        new Thread(() -> {
            while (resume.getFlag()) {
                try {
                    TimeUnit.MILLISECONDS.sleep(3);
                    resume.resolveResume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "面试官A").start();
        new Thread(() -> {
            while (resume.getFlag()) {
                try {
                    TimeUnit.MILLISECONDS.sleep(5);
                    resume.resolveResume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "面试官B").start();

    }
}

/**
 * 简历
 */
class Resume {
    /**
     * 简历编号
     */
    private AtomicInteger no = new AtomicInteger(1);
    private AtomicInteger noCount = new AtomicInteger(0);
    private volatile boolean flag = true;

    Resume() {
    }

    Resume(AtomicInteger i) {
        this.no = i;
    }

    public int getNo() {
        return no.get();
    }

    public boolean getFlag() {
        return flag;
    }


    Lock lock = new ReentrantLock();
    Condition conditionHR = lock.newCondition();
    Condition conditionInterviewer = lock.newCondition();

    /**
     * HR 收集简历
     */
    public void collectResume() {
        lock.lock();
        try {
            while (noCount.get() == 10) {
                conditionHR.await();
            }
            System.out.println(Thread.currentThread().getName() + "获得了第" + no + "份简历!");
            no.getAndIncrement();
            noCount.getAndIncrement();
            conditionInterviewer.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 面试官 处理简历
     */
    public void resolveResume() {
        lock.lock();
        try {
            if (no.get() == 100) {
                flag = false;
                return;
            }
            if (noCount.get() == 0) {
                conditionInterviewer.await();
            }
            System.out.print(Thread.currentThread().getName() + "查看了第" + no.get() + "份简历!");
            noCount.decrementAndGet();
            String[] feedback = new String[]{"通过", "不通过"};
            Random random = new Random();
            int resultNo = random.nextInt(2);
            System.out.println("   HR: " + no.get() + "号简历的结果是:" + feedback[resultNo]);
            conditionHR.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
