package com.zgy.learn.springbootshiro.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: renjiaxin
 * @Despcription: 登录
 * @Date: Created in 2020/2/17 13:39
 * @Modified by:
 */
@Slf4j
@Controller
public class LoginController {
    // Logger log =LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = {"/", "/index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为 UsernamePasswordToken对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // remember me
            token.setRememberMe(true);
            try {
                // 尝试登录
                currentUser.login(token);
            } catch (AuthenticationException e) {
                System.out.println("登录失败: " + e.getMessage());
                log.error("登录失败: ", e);
            }
        }
        return "list";
    }

}
