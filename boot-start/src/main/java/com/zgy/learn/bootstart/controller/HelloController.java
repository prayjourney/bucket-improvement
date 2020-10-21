package com.zgy.learn.bootstart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: renjiaxin
 * @Description: contorller, 返回json
 * @Date: 2019-12-03 01:20
 * @Modified by:
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello boot!";
    }
}
