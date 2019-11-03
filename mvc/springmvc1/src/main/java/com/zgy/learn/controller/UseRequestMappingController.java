package com.zgy.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
    public String getTime(Model model) {
        System.out.println("get time: " + LocalDateTime.now());
        // 定义了一个变量， 用来装载我们的数据
        model.addAttribute("timenow",LocalDateTime.now().toString());
        return "timenow";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String helloMap(ModelMap map, String name) {
        /**
         * 传值, 在方法中, 或者在url之中,其实都是在方法之中的意思, 一样的, 点击一下之后, 就会是一个url带值得样子了
         * 我们可以使用Model, ModelMap, ModelAndView来, 将后端的值, 传给前端的页面等
         */
        map.addAttribute("name",name);
        System.out.println("hello " + name);
        return "hello";
    }
}
