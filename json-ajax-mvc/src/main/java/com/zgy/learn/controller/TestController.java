package com.zgy.learn.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zgy.learn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @RequestMapping(value = "/json1", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json1() throws JsonProcessingException {
        // 需要一个对象
        // 需要一个jackson的对象映射器，就是一个雷，使用它可以直接将对象转换为json字符串

        ObjectMapper mapper = new ObjectMapper();
        // 创建一个对象
        User user = new User("张三", 22, "男");

        // 将Java对象转换为json字符串
        String s = mapper.writeValueAsString(user);
        System.out.println(s);
        return s;
    }

    // 使用@ResponseBody，就可以直接返回json类型，不看方法的返回类型是什么
    @RequestMapping(value = "/json2", produces = "application/json;charset=utf-8")
    @ResponseBody
    public User json2() throws JsonProcessingException {
        User user = new User("王美娟", 26, "女");
        System.out.println(user);
        return user;
    }

    // 返回一个list
    @RequestMapping(value = "/json3", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json3() throws JsonProcessingException {
        List<User> users = new ArrayList<>();
        User user1 = new User("王美娟1", 26, "女");
        User user2 = new User("王美娟2", 22, "女");
        User user3 = new User("王美娟3", 29, "男");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        System.out.println(users);
        return new ObjectMapper().writeValueAsString(users);
//        [
//            {
//                "name": "王美娟1",
//                    "age": 26,
//                    "gender": "女"
//            },
//            {
//                "name": "王美娟2",
//                    "age": 22,
//                    "gender": "女"
//            },
//            {
//                "name": "王美娟3",
//                    "age": 29,
//                    "gender": "男"
//            }
//        ]
    }

    @RequestMapping(value = "/time1", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String time1() {
        // 返回时间戳
        return String.valueOf(System.currentTimeMillis());
    }

    // 不让返回时间戳
    @RequestMapping(value = "/time2", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String time2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        // 1.不让返回时间戳，就要关闭时间戳功能
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        // 2.自定义时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 3.指定日期格式
        mapper.setDateFormat(sdf);

        // 给一个时间戳
        return mapper.writeValueAsString(new Date());
    }

    // 使用Java8的时间
    @RequestMapping(value = "/time3", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String time3() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
