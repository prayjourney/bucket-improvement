package com.zgy.learn.controller;

import org.springframework.stereotype.Controller;
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
    @RequestMapping(value = "param")
    public String TestParam(@RequestParam String name,
                            @RequestParam(required = true, defaultValue = "0") int age,
                            @RequestParam(required = false) String gender) {
        // 其实这个都不需要任何返回的
        return "testparam";
    }
    @RequestMapping(value = "head")
    public String TestParamHead(@RequestHeader String name){
        // 其实这个都不需要任何返回的, 还有一个是cookie
        return "testparam";
    }

}
