package com.zgy.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: renjiaxin
 * @Description: 调用自定义的视图解析器
 * @Date: 2019-11-07 04:26
 * @Modified by:
 */
@Controller
public class HelloViewController {
    @RequestMapping("helloView")
    public String helloViewTest(){
        return "helloView";
    }

}

