package com.zgy.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description: 使用几种传数据的类型
 * @Date: 2019-11-05 10:53
 * @Modified by:
 */
@Controller
@RequestMapping("data")
public class UseDataModel {
    // 请求和响应的分野在那儿, 为什么我在此处应该是对于一个请求的响应, 但是我添加在model里面的值, 是要在requestScopes之中获取呢?
    @RequestMapping("model")
    public String useModel(Model model){
        model.addAttribute("hello","hello-world");
        return "data";
    }
    @RequestMapping("map")
    public String useMap(Map<String, String> mp){
        mp.put("你好","nihao, z.g.y");
        return "data";
    }
    @RequestMapping("modelmap")
    public String useModelMap(ModelMap modelMap){
        // ModelMap和Map其实是一样的, 前三个,都是Map, ModelAndView在返回的key-value的同时, 也给了一个view, 其他没啥差别
        modelMap.addAttribute("what","what are you doing!");
        return "data";
    }
    @RequestMapping("modelandview")
    public ModelAndView useModelAndView(ModelAndView mv){
        String viewName = "data";
        // 设置view名字, 默认返回的是requestmapping的值, 如果在不设置名字的时候
        mv.setViewName(viewName);
        mv.addObject("ai","坚持一下, 慢慢熬吧!");
        return mv;
    }

}
