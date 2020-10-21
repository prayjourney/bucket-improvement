package com.zgy.learn.springbootshiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/18 18:05
 * @Modified by:
 */
@Controller
public class UserController {
    @RequestMapping(value = "/user")
    public String user() {
        return "user";
    }

    @RequestMapping(value = "/admin")
    public String list() {
        return "admin";
    }

}
