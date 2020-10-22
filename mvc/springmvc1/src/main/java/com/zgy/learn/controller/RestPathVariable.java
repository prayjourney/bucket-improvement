package com.zgy.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-04 10:05
 * @Modified by:
 */
@Controller
@RequestMapping(value = "rest")
public class RestPathVariable {
    @RequestMapping(value = "hello/{name}", method = RequestMethod.GET)
    public String helloRest(@PathVariable("name") String name) {
        System.out.println("hello " + name);
        return "resthello";
    }

    /**
     * PathVariable限定的入参的名字和使用RequestMapping修饰的请求里面的属性值要相同的
     *
     * @param model
     * @param name
     * @return
     */
    @RequestMapping(value = "hello2/{name2}", method = RequestMethod.GET)
    public String helloRest2(Model model, @PathVariable("name2") String name) {
        System.out.println("hello " + name + ", " + "我是第二个方法");
        model.addAttribute("name2", name);
        return "resthello";
    }

}
