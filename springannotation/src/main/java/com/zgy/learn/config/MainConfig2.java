package com.zgy.learn.config;

import com.zgy.learn.bean.Person;
import com.zgy.learn.condition.LinuxCondition;
import com.zgy.learn.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/28 2:24
 * @Modified by:
 */
//类中组件统一设置。满足当前条件，这个类中配置的所有bean注册才能生效；
//@Conditional({WindowsCondition.class})
@Configuration
public class MainConfig2 {

    /**
     * 默认是单实例的
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE
     *
     * @return\
     * @Scope:调整作用域 prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。
     * 每次获取的时候才会调用方法创建对象；
     * singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。
     * 以后每次获取就是直接从容器（map.get()）中拿，
     * request：同一次请求创建一个实例
     * session：同一个session创建一个实例
     * <p>
     * 懒加载：
     * 单实例bean：默认在容器启动的时候创建对象；
     * 懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；
     * <p>
     * ConfigurableBeanFactory#SCOPE_SINGLETON
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION     sesssion
     */
    @Bean(name = "guanyu")
    @Scope(scopeName = "singleton") // 默认就是singleton
    public Person getPerson() {
        System.out.println("开始调用，创建对象。。。");
        return new Person("guanyu", 27);
    }

    @Scope(value = "prototype")
    @Bean(name = "ceshi")
    public Person getPerson2() {
        System.out.println("开始调用，创建对象。。。");
        return new Person("王麻子", 23);

    }

    @Scope(value = "singleton")
    @Bean(name = "ceshi2")
    @Lazy(value = true) // 懒加载默认是true, singleton默认容器创建就加载，使用@Lazy, 可以让它在调用的时候再去创建
    public Person getPerson3() {
        System.out.println("开始调用，创建对象。。。");
        return new Person("大麻子", 23);

    }

    /**
     * @Conditional({Condition}) ： 按照一定的条件进行判断，满足条件给容器中注册bean
     * <p>
     * 如果系统是windows，给容器中注册("bill")
     * 如果是linux系统，给容器中注册("linus")
     */

    @Bean("bill gates")
    @Conditional(value = WindowsCondition.class)// 按照WindowsCondition的匹配条件来匹配
    public Person winPerson() {
        return new Person("bill gates", 62);
    }

    @Bean("linux")
    @Conditional(value = LinuxCondition.class)
    public Person linuxPerson() {
        return new Person("linux", 51);
    }
}
