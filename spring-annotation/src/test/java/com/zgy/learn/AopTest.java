package com.zgy.learn;

import com.zgy.learn.aop.MathCalculator;
import com.zgy.learn.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/30 21:39
 * @Modified by:
 */
public class AopTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        //1、不要自己创建对象
        // MathCalculator mathCalculator = new MathCalculator();
        // mathCalculator.div(1, 1);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);

        mathCalculator.div(1, 2);

        applicationContext.close();
    }

}
