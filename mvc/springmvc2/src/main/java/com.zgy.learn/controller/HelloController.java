package com.zgy.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-07 05:01
 * @Modified by:
 */
@Controller
public class HelloController {
    @RequestMapping("hello")
    public String hello(){
        return "index";
    }
}
