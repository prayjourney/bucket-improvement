package com.zgy.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: renjiaxin
 * @Description: 测试@RequestParam
 * @Date: 2019-11-04 15:11
 * @Modified by:
 */
@Controller
@RequestMapping("some")
public class SomeParams {
    // 这个是要求一些参数是否要必须在请求之中有
    @RequestMapping(value = "param")
    public String TestParam(@RequestParam String name,
                            @RequestParam(required = true, defaultValue = "0") int age,
                            @RequestParam(required = false) String gender) {
        // 其实这个都不需要任何返回的
        return "testparam";
    }
    @RequestMapping(value = "head")
    public String TestParamHead(@RequestHeader("Accept-Encoding") String AcceptEncoding, Model model){
        // 使用时候,还是要和header的具体属性相关联
        // 其实这个都不需要任何返回的, 就是一个header的属性, 为了方便, 加上model, 传给前端显示
        model.addAttribute("AcceptEncoding", AcceptEncoding);
        return "testparam";
    }

    @RequestMapping(value = "cookie")
    public String TestCookieValue(@CookieValue("JSESSIONID")String cookie, Model model){
        // 使用时候,还是要和cookie的具体属性相关联
        // 其实这个都不需要任何返回的, 就是一个cookie的属性, 为了方便, 加上model, 传给前端显示
        model.addAttribute("cookieid", cookie);
        return "testparam";
    }

}
