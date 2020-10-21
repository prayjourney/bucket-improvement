package com.zgy.learn.condition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/28 19:34
 * @Modified by:
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * AnnotationMetadata：当前类的注解信息
     * BeanDefinitionRegistry:BeanDefinition注册类；
     * 把所有需要添加到容器中的bean；调用
     * BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean hasBlue = registry.containsBeanDefinition("com.zgy.learn.bean.Blue");
        boolean hasRed = registry.containsBeanDefinition("com.zgy.learn.bean.Red");
        if (hasBlue && hasRed) {
            // 可以自定义bean的名称等信息, 名称是rainbow, RootBeanDefinition是BeanDefinition接口的实现类型
            BeanDefinition beanDefination = new RootBeanDefinition("com.zgy.learn.bean.Rainbow");
            // 设置了bean名
            registry.registerBeanDefinition("rainbow", beanDefination);
            // 设置了bean的scope
            registry.getBeanDefinition("rainbow").setScope("singleton");
        }

    }
}
