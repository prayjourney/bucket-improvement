package com.zgy.learn.bootcrud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Despcription: 登录
 * @Date: Created in 2019/12/14 15:37
 * @Modified by:
 */
@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger(getClass());

//    @DeleteMapping
//    @PutMapping
//    @GetMapping

    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    // RequestParam要求前端传入的参数必须是这个名字，map为了存放数据信息，session为了检查是否登录
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            logger.debug("用户开始登录。。。。");
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else {
            //登陆失败
            logger.debug("用户登录失败。。。。");
            map.put("msg", "用户名密码错误");
            return "login";
        }

    }
}
