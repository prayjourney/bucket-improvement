package com.zgy.learn.bootstart.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-12-03 02:02
 * @Modified by:
 */
@Component
@ConfigurationProperties(prefix = "person")
@Data
public class Person {
    @Value("李四啊")
    private String lastName;
    @Value("#{22-5*1.2}")
    private Integer age;
    private Boolean boos;
    private Date birthday;

    private Map<String, Object> maps;
    private List<Object> lists;

    private Dog dog;
}
