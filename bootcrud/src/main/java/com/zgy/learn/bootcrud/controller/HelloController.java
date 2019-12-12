package com.zgy.learn.bootcrud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-12-13 01:01
 * @Modified by:
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String helloController() {
        return "hello boot crud!";
    }
}
