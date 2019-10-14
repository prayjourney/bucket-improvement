package com.zgy.learn.java8.lambda.ofiical;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * lambda虽然挺好的，但是我们每次要去写一个接口，挺麻烦的，所以我们可以使用官方提供的四个标准接口
 * /*
 * * Java8 内置的四大核心函数式接口
 * *
 * * Consumer<T> : 消费型接口
 * * 		void accept(T t);
 * *
 * * Supplier<T> : 供给型接口
 * * 		T get();
 * *
 * * Function<T, R> : 函数型接口
 * * 		R apply(T t);
 * *
 * * Predicate<T> : 断言型接口
 * * 		boolean test(T t);
 * *
 * https://www.cnblogs.com/drl-blogs/p/10803413.html
 */
public class StandardUse {
    /**
     * 确定我们使用四大接口之中 的哪一种接口，这个的话关键在于，我们的返回值和参数
     * 消费型接口：无返回值，一个参数
     * 供给型接口：有返回值，无参数
     * 函数型接口：有返回值，一个参数
     * 断言型接口：boolean返回值，一个参数
     */
    // 1. 消费型接口, 无返回值，一个参数
    public void findFun(String mm, Consumer<String> s) {
        s.accept(mm);
    }

    // 测试消费型接口
    @Test
    public void testConsumer() {
        findFun("旅游", s -> System.out.println("我的爱好是：" + s));
    }

    // 2.供给型接口, 有返回值，无参数
    // 此处说的有无返回值， 是四大接口的有无返回值，和我们要实现的方法， 比如此处的getNumberList无关
    public List<Integer> getNumberList(int num, Supplier<Integer> su) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 相当于这一部分是个半成品，我们需要在调用的时候实际实现，这是就用到了lambda表达式
            ls.add(su.get());
        }
        return ls;
    }

    // 测试消费型接口
    @Test
    public void testSupplier() {
        // 是说，此处的Supplier接口，有返回值，无参数
        List<Integer> ll = getNumberList(10, () -> {
            Random r = new Random();
            return r.nextInt(100);
        });
        for (Integer i : ll) {
            System.out.println(i);
        }
    }

}
