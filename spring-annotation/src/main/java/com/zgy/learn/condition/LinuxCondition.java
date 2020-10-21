package com.zgy.learn.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: renjiaxin
 * @Despcription: 判断是否是linux操作系统， 在运行参数之中配置 -Dos.name=linux可以修改os参数名， 使用-Dxxx， 修改参数， 固定写法
 * @Date: Created in 2019/12/28 4:17
 * @Modified by:
 */
public class LinuxCondition implements Condition {
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

        String[] activeProfiles = environment.getActiveProfiles();
        System.out.println("当前激活的profiles:");
        for (String profile : activeProfiles) {
            System.out.println(profile);
        }
        // 判断是否注册了ceshi2这个bean, @Lazy的使用
        boolean ceshi2 = registry.containsBeanDefinition("ceshi2");
        System.out.println("由于是@lazy的模式， 所以还没有加载");

        if (osName.contains("linux")) {
            return true;
        }

        return false;
    }
}
