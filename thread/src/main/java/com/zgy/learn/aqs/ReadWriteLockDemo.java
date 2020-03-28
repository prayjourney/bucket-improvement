package com.zgy.learn.aqs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: renjiaxin
 * @Despcription: 读写锁的测试
 * @Date: Created in 2020/3/28 22:43
 * @Modified by:
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache cache = new MyCache();
        // 写入
        for (int i = 0; i < 5; i++) {
            final int x = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ": 设置");
                cache.set(x + "", x + "");
                System.out.println(Thread.currentThread().getName() + ": 设置完毕, " + x
                        + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            }, "写入线程：" + String.valueOf(x)).start();
        }

        // 读取
        for (int i = 0; i < 5; i++) {
            final int x = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ": 读取");
                cache.get(x + "");
                System.out.println(Thread.currentThread().getName() + ": 读取完毕, " + x
                        + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            }, "读取线程：" + String.valueOf(x)).start();
        }
    }
}

/**
 * 资源类，一个缓存
 */
class MyCache {
    public volatile Map<String, Object> mycache = new HashMap<>();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /**
     * 读取缓存，读读共享，读写互斥
     * //现在这样，写锁上了锁，而读锁没有上锁，这样会导致读和写不互斥，所以会出现问题
     */
    public Object get(String key) {
        // 上锁
        readWriteLock.readLock().lock();
        try {
            return mycache.get(key);
        } finally {
            // 开锁
            readWriteLock.readLock().unlock();
        }
    }

    /**
     * 写入缓存，写写互斥，读写互斥
     */
    public void set(String key, Object value) {
        // 上锁
        readWriteLock.writeLock().lock();
        try {
            TimeUnit.MILLISECONDS.sleep(200);
            mycache.put(key, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 开锁
            readWriteLock.writeLock().unlock();
        }
    }

}
