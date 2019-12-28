package com.zgy.learn.config;

import com.zgy.learn.bean.Color;
import com.zgy.learn.bean.Person;
import com.zgy.learn.bean.Red;
import com.zgy.learn.condition.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: renjiaxin
 * @Despcription: 各种定义bean的方式
 * @Date: Created in 2019/12/28 18:55
 * @Modified by:
 */
@Configuration
@ComponentScan(basePackages = "com.zgy.learn.bean") // 定义扫描的路径
@Import(value = {Red.class, Color.class, MyImportSelector.class})
// 快速导入组件，默认的名称是全类名的小写，如com.zgy.learn.bean.Red，可以放多个，成为一个数组
// 把自定义的规则MyImportSelector也加入到其中，ImportSelector接口实现类需要配合Import使用
public class BeanDefineConfig {
    // 普通的bean定义方式
    @Bean(value = "guanyu01")
    public Person getPerson() {
        return new Person("关羽", 38);
    }

}
