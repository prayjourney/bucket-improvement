package com.zgy.learn.bootstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("mycon")
    public String mycontroller(){
        return "my controller 123!";
    }
}
