package com.zgy.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

/**
 * @Author: renjiaxin
 * @Despcription: 对类和方法使用RequestMapping， 默认就是地址， 还有方法的指定
 * @Date: Created in 2019/11/3 23:41
 * @Modified by:
 */
// 类使用RequestMapping
@Controller
@RequestMapping("requestmap")
public class UseRequestMappingController {
    // 方法使用RequestMapping
    @RequestMapping(value = "gettime")
    public String getTime(Model model) {
        System.out.println("get time: " + LocalDateTime.now());
        // 定义了一个变量， 用来装载我们的数据
        model.addAttribute("timenow", LocalDateTime.now().toString());
        return "timenow";
    }

    // RequestMapping的method方法
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String helloMap(ModelMap map, String name) {
        /**
         * 传值, 在方法中, 或者在url之中,其实都是在方法之中的意思, 一样的, 点击一下之后, 就会是一个url带值得样子了
         * 我们可以使用Model, ModelMap, ModelAndView来, 将后端的值, 传给前端的页面等
         */
        map.addAttribute("name", name);
        System.out.println("hello " + name);
        return "hello";
    }


    // post方法需要使用到表单来完成
    // 调用的流程是  某一个url--->controller--->处理的结果页面
    @RequestMapping(value = "hellopost", method = RequestMethod.POST)
    public String helloMap2(ModelMap map, String username, String email, String age) {
        map.addAttribute("username", username);
        map.addAttribute("email", email);
        map.addAttribute("age", age);
        // 完全是后端传给前端的一个值
        map.addAttribute("info","你好呀, 我是一个测试的信息呀! 完全是后端传给前端的一个值");
        System.out.println("hello " + username + ", " + email + ", " + age);
        return "usepost";
    }

}
