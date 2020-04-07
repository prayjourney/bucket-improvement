package com.zgy.learn.tools;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: renjiaxin
 * @Despcription: CachedData
 * @Date: Created in 2020/4/7 22:17
 * @Modified by:
 */
public class CachedData {
    List<String> data = new ArrayList<>();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock(false);
    Lock writeLock = lock.writeLock();
    Lock readLock = lock.readLock();

    public boolean isValid() {
        SecureRandom random = new SecureRandom();
        return random.nextBoolean();
    }

    /**
     * 处理数据
     */
    public void processCachedData() {
        if (isValid()) {
            readLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + ": process data...");
            } finally {
                readLock.unlock();
            }
        } else {
            writeLock.lock();
            readLock.lock();
            try {
                TimeUnit.MILLISECONDS.sleep(10);
                System.out.println("update cache data...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
                readLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        CachedData cache = new CachedData();
        System.out.println(cache.isValid());
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                    cache.processCachedData();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                    cache.processCachedData();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                    cache.processCachedData();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
    }
}
