package com.zgy.learn.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: renjiaxin
 * @Despcription: 判断是否是win操作系统
 * @Date: Created in 2019/12/28 4:17
 * @Modified by:
 */
public class WindowsCondition implements Condition {
    /**
     * ConditionContext：判断条件能使用的上下文（环境）
     * AnnotatedTypeMetadata：注释信息
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取bean使用的工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 获取类加载器
        ClassLoader cls = context.getClassLoader();
        // 获取当前的环境
        Environment environment = context.getEnvironment();
        // 获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        String osName = environment.getProperty("os.name");
        System.out.println("os name: " + osName);

        if (osName.contains("Win")) {
            return true;
        }

        return false;
    }
}
