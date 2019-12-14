package com.zgy.learn.bootcrud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-12-13 01:01
 * @Modified by:
 */
// @RestController
@Controller
public class HelloController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @RequestMapping("hellocrud")
    public String helloController() {
        logger.debug("访问方法： {}, 日期：{}", "helloController", LocalDate.now());
        // ctrl+alt+v 提取出来一个值，作为变量，并且带着他的类型
        String crud = "crud";
        return "hello boot " + crud + "!";
    }

    // 使用getmapping = get方法的RequestMapping， 添加了多个请求， 返回页面
    @GetMapping({"/","/index.html","login.html"})
    public String index(){
        return "login";
    }


}
