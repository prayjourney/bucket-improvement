package com.zgy.learn.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zgy.learn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/4/12 17:57
 * @Modified by:
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {
    @RequestMapping("/a1")
    public void ajax(String name, HttpServletResponse response) throws IOException {
        if ("admin".equals(name)){
            response.getWriter().print(true);
        }else{
            response.getWriter().print(false);
        }
    }

    @RequestMapping("learnajax")
    public String goToPage(){
        return "forAjaxList";
    }

    // 返回多个值
    @RequestMapping("/a2")
    @ResponseBody
    public List<User> ajax2(String name, HttpServletResponse response) throws IOException {
        List<User> users = new ArrayList<>();
        User user1 = new User("王美娟1", 26, "女");
        User user2 = new User("王美娟2", 22, "女");
        User user3 = new User("王美娟3", 29, "男");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        System.out.println(users);
        return users;
    }

}
