package com.zgy.learn.bootstart.controller;

import com.zgy.learn.bootstart.BootstartApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description: controller, restbody, restcontroller三者的關係
 * @Date: 2019-12-12 23:40
 * @Modified by:
 */
//@Controller      // controller
//@RestBody        // json
@RestController    // controller + json
public class MyController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("mycon")
    public String test() {
        logger.debug("开始访问mycontroller方法, 直接返回一个json子字符串, 返回的字符串就是retrn内容");
        // 返回的是json, 而不是一个页面, 所以在templates里面不需要对应名称的html页面
        Map<String, String> mp = new HashMap<>();
        mp.put("name", "张三");
        mp.put("age", "23");
        mp.put("gender", "男");
        return "my controller 123!" + mp.values();
    }
}
