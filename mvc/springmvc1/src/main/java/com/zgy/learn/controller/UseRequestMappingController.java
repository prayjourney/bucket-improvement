package com.zgy.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

/**
 * @Author: renjiaxin
 * @Despcription: 对类和方法使用RequestMapping， 默认就是地址， 还有方法的指定
 * @Date: Created in 2019/11/3 23:41
 * @Modified by:
 */
@Controller
@RequestMapping("requestmap")
public class UseRequestMappingController {
    @RequestMapping(value = "gettime")
    public String getTime(ModelAndView model) {
        System.out.println("get time: " + LocalDateTime.now());
        // 定义了一个变量， 用来装载我们的数据
        model.addObject("timenow",LocalDateTime.now().toString());
        return "timenow";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String helloMap(String name) {
        System.out.println("hello " + name);
        return "hello";
    }
}
