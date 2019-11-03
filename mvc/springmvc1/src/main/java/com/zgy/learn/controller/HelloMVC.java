package com.zgy.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-03 16:10
 * @Modified by:
 */
@Controller
public class HelloMVC{
    /**
     * 通过视图解析器InternalResourceViewResolver, 将视图解析为实际的物理视图, 会解析为
     * prefix + returnvalue + suffix, 然后转发的相应的视图上去
     * @return
     */
    @RequestMapping(value ="mvc")
    public String hello() {
        System.out.println("hello spring mvc!");
        return "success";
    }
}
