package com.zgy.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description: Post方法模拟Put和Delete, from表单只是支持get 和post这两个标准的
 * @Date: 2019-11-09 01:34
 * @Modified by:
 */
@Controller
public class Post2PutDeleteController {
    @RequestMapping(value = "post2put/{name}", method = RequestMethod.PUT)
    public String post2Put(@PathVariable("name") String name, ModelMap map) {
        String newName = "new Name";
        System.out.println("我更新了name: " + name + ", 新的值是: " + newName);
        map.addAttribute("oldname", name);
        map.addAttribute("newname", newName);
        return "post2put";

    }

    @RequestMapping(value = "post2delete/{id}", method = RequestMethod.DELETE)
    public String post2Delete(@PathVariable("id") Integer id, Map<String, Integer> mp) {
        System.out.println("我删除了id: " + id);
        mp.put("deleteid", id);
        return "post2delete";

    }
}
