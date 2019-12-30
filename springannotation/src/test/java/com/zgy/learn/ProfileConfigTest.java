package com.zgy.learn;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zgy.learn.bean.Yellow;
import com.zgy.learn.config.ConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.activation.DataSource;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/30 17:31
 * @Modified by:
 */
public class ProfileConfigTest {

    //1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
    //2、代码的方式激活某种环境；
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ConfigOfProfile.class);



        String[] namesForType = applicationContext.getBeanNamesForType(ComboPooledDataSource.class);
        for (String string : namesForType) {
            System.out.println(string);
            System.out.println(1111);
        }

        Yellow bean = applicationContext.getBean(Yellow.class);
        System.out.println(bean);
        applicationContext.close();
    }

}
