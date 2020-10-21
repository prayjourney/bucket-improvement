package com.zgy.learn.tools;

/**
 * @Author: renjiaxin
 * @Despcription: 数组模拟队列
 * @Date: Created in 2020/4/7 21:09
 * @Modified by:
 */
public class MyQueue {
    // 数组充当容器
    private Object[] queue;
    // 默认大小
    private static final int DEFALUT_SIZE = 10;
    // 队头
    private int front = 0;
    // 队尾
    private int rear = 0;
    // 队列容量
    private int capacity = 0;
    // 使用量
    private int size = 0;

    public MyQueue() {
        capacity = DEFALUT_SIZE;
        queue = new Object[capacity];
    }

    public MyQueue(int capacity) {

        queue = new Object[capacity];
    }

    /**
     * 压入一个新的对象，放到队尾, 如果队列满了，报错
     *
     * @param obj
     * @return true or false 入队是否成功
     */
    public void push(Object obj) {
        if (front > rear || rear > capacity) {
            throw new RuntimeException("入队失败！");
        }
        if (((rear - front) + 1) % capacity == 0) {
            throw new RuntimeException("队列已满！");
        }
        queue[rear] = obj;
        rear++;
        size++;
    }

    /**
     * 弹出最先进入的对象，并且删除该元素
     *
     * @return obj
     */
    public Object pop() {
        if (front >= rear || rear > capacity) {
            throw new RuntimeException("没有元素!");
        }
        int cur = front;
        front++;
        size--;
        return queue[cur];

    }

    /**
     * 弹出最先进入的对象，但是不删除
     *
     * @return obj
     */
    public Object peek() {
        if (front >= rear || rear > capacity) {
            throw new RuntimeException("没有元素!");
        }
        int cur = front;
        return queue[cur];
    }

    /**
     * 查看队列是否为空
     *
     * @return true or false
     */
    public boolean empty() {
        return (rear - front) == 0;
    }

    /**
     * 查看队列的占用了的长度
     *
     * @return size
     */
    public int size() {
        return rear - front;
    }

    /**
     * 打印队列
     */
    public void printQueue() {
        if (size == 0) {
            throw new RuntimeException("空队列！");
        }
        for (int i = front; i < rear; i++) {
            System.out.println(queue[i]);
        }
    }

}

/**
 * 测试类
 */
class QueueTest {
    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.push("123");
        mq.push("456");
        mq.push("789");
        mq.push("aaa");
        System.out.println(mq.peek());
        System.out.println(mq.size());
        System.out.println(mq.pop());
        System.out.println(mq.pop());
        System.out.println(mq.empty());
        System.out.println(mq.size());
        mq.printQueue();
    }
}
