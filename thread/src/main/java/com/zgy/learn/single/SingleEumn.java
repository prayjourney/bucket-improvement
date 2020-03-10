package com.zgy.learn.single;

/**
 * 自带单例，然后是可以防止反射破解，但是和饿汉基本上就是一致的了
 */
public enum SingleEumn {
    SINGLE_EUMN;

    public static SingleEumn getInstance() {
        return SINGLE_EUMN;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                System.out.println(getInstance().hashCode());
            }).start();
        }
    }
}
