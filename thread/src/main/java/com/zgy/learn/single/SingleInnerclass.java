package com.zgy.learn.single;

/**
 * 内部类单例，无线程问题，作用和DCL单例一样，防不住反射
 */
public class SingleInnerclass {
    private SingleInnerclass() {
    }

    public static SingleInnerclass getInstance() {
        return Innerclass.Holder();

    }

    // 内部静态类的实现方式
    static class Innerclass {
        static SingleInnerclass s;

        static synchronized SingleInnerclass Holder() {
            if (s == null) {
                s = new SingleInnerclass();
            }
            return s;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                System.out.println(getInstance().hashCode());
            }).start();
        }
    }
}
