package com.zgy.learn.config;

import com.zgy.learn.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: renjiaxin
 * @Despcription: Bean生命周期管理
 * @Date: Created in 2019/12/29 11:55
 * @Modified by:
 */
@Configuration
public class BeanLifeCycleConfig {
    // 定义了初始化方法和销毁方法
    @Bean(initMethod = "init", destroyMethod = "myDestoryMethod")
    public Cat cat() {
        return new Cat();
    }
}
