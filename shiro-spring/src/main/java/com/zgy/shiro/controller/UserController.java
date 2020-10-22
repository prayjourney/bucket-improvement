package com.zgy.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/16 20:05
 * @Modified by:
 */
@Controller
public class UserController {
    @RequestMapping(value = "/userinfo")
    public String getUserInfo(HttpServletRequest request) {
        String currentUser = (String) request.getSession().getAttribute("currentUser");
        System.out.println("当前登录的用户为[" + currentUser + "]");
        request.setAttribute("currUser", currentUser);
        return "/user";
    }
}
