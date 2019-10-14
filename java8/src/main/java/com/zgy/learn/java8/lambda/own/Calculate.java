package com.zgy.learn.java8.lambda.own;

import org.junit.Assert;
import org.junit.Test;

public class Calculate {
    // 这只是一个半成品，我们需要的时候需要在调用的时候实现接口方法， 在其中的话，我们就会使用到lambda表达式
    public Integer calculate(int a, int b, CalculateInterface<Integer> cal) {
        Integer result = cal.calcuate(a, b);
        return result;
    }

    // 我们实际需要解决问题的时候，再去实现接口里面的方法，然后就能得到我们想要的值了
    @Test
    public void testCalculateAdd() {
        Integer result = calculate(1, 2, (a, b) -> a + b);
        System.out.println(result);
        Assert.assertTrue(3 == result);
    }

    @Test
    public void testCalculateSub() {
        Integer result = calculate(1, 2, (a, b) -> a - b);
        System.out.println(result);
        Assert.assertTrue(-1 == result);
    }
}
