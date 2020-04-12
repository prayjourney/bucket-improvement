package com.zgy.learn.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zgy.learn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/4/12 14:48
 * @Modified by:
 */
@Controller
public class TestController {
    @RequestMapping("/json0")
    public String json0() {
        // 这样返回的是一个视图，需要到WEB-INF/views/里面去找hello
        return "hello";
    }

    // @RequestBody, 前端请求的时候，作为一个json传入
    // @ResponseBody, 将服务器端返回的对象，转换为json对象，响应回去
    @RequestMapping("/json1")
    @ResponseBody
    public String json1() throws JsonProcessingException {
        // 需要一个对象
        // 需要一个jackson的对象映射器，就是一个雷，使用它可以直接将对象转换为json字符串

        ObjectMapper mapper = new ObjectMapper();
        // 创建一个对象
        User user = new User("张三", 22, "男");

        // 将Java对象转换为json字符串
        String s = mapper.writeValueAsString(user);
        return s;
    }
}
