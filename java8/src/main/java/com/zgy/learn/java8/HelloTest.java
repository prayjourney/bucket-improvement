package com.zgy.learn.java8;

/**
 * https://blog.csdn.net/tianjindong0804/article/details/81710268
 * https://www.cnblogs.com/z-sm/p/7058864.html
 * https://cuipengfei.me/blog/2013/06/22/why-does-it-have-to-be-final/
 * 事实上，除了匿名内部类内部，方法和作用域内的内部类内部使用的外部变量也必须是 final 的。
 * 原因如下：内部类会自动拷贝外部变量的引用，为了避免：1. 外部方法修改引用，而导致内部类得到的引用值不一致
 * 2.内部类修改引用，而导致外部方法的参数值在修改前和修改后不一致。于是就用 final 来让该引用不可改变。
 * <p>
 * 链接：https://www.zhihu.com/question/21395848/answer/39841533
 */
public class HelloTest {
    public static void main(String[] args) {
        // 在java8之前，如果匿名内部类要使用，则必须加上final，java8自动加上了final，我们可以不去显示的写
        final String str = "haha";
        new Thread() {
            @Override
            public void run() {
                System.out.println(str);
            }
        }.start();
    }

    public void lookInnerClass() {
        final int age = 25;
        final String name = "张三";
        HelloTest ht = new HelloTest();
        ht.new MyInnerClass();
        this.new MyInnerClass() {
            // 不加final, 在JDK7之前直接报错
            @Override
            public void test(int a, String n) {
                a = age;
                // 无法修改
                // age++;
                n = name;
                // 无法修改
                // name ="1"+name;
            }
        };
    }

    // 一个内部类
    class MyInnerClass implements OkTest {
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "MyInnerClass{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public void test(int age, String name) {

        }
    }
}

// 一个测试接口
interface OkTest {
    void test(int age, String name);
}
