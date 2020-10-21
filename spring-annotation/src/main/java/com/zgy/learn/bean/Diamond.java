package com.zgy.learn.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/29 23:58
 * @Modified by:
 */
@Getter
@Setter
@ToString
@Component("diamondxxx") // 加入到组件之中
public class Diamond {
    //使用@Value赋值；
    //1、基本数值
    //2、可以写SpEL； #{}
    //3、可以写${}；取出配置文件【properties】中的值（在运行环境变量里面的值）

    @Value("蓝色火焰")
    private String name;
    @Value("#{23-2}")
    private Double weight;
    @Value("${diamond.price}")
    private Double price;
    //@Value("2019-1-2")
    //private Date date;
    @Value("2019-1-2")
    private String date;
}
