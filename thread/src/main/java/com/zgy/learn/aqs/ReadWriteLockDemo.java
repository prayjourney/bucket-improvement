package com.zgy.learn.aqs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
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
                System.out.println(Thread.currentThread().getName() + "设置");
                cache.set(x + "", x + "");
                System.out.println(Thread.currentThread().getName() + "设置完毕" + x
                        + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            }, "写入线程：" + String.valueOf(x)).start();
        }

        // 读取
        for (int i = 0; i < 5; i++) {
            final int x = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "读取");
                cache.get(x + "");
                System.out.println(Thread.currentThread().getName() + "读取完毕" + x
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
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 读取缓存，现在这样，写锁上了锁，而读锁没有上锁，这样会导致读和写不互斥，所以会出现问题
     */
    public Object get(String key) {
        return mycache.get(key);
    }

    /**
     * 写入缓存，写写互斥，读写互斥
     */
    public void set(String key, Object value) {
        // 上锁
        lock.writeLock();
        try{
            mycache.put(key, value);
        }finally {
            // 开锁
            lock.writeLock().unlock();
        }

    }

}
