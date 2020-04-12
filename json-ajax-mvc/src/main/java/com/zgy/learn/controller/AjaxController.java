package com.zgy.learn.controller;

import com.zgy.learn.pojo.User;
import org.springframework.stereotype.Controller;
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
    @RequestMapping(value = "/a2")
    @ResponseBody
    public List<User> ajax2() throws IOException {
        List<User> users = new ArrayList<>();
        User user1 = new User("周芷若", 26, "女");
        User user2 = new User("赵敏", 23, "女");
        User user3 = new User("苏小昭", 22, "女");
        User user4 = new User("张无忌", 29, "男");
        User user5 = new User("谢逊", 67, "男");
        User user6 = new User("张三丰", 119, "男");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        System.out.println(users);
        return users;
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    // 这就是一个正常的请求，不过是要给前端返回信息
    @RequestMapping(value = "/a3")
    @ResponseBody
    public String ajax3(String name, String pwd) throws IOException {
        String msg = "";
        if (null != name){
            if ("admin".equals(name)){
                msg ="OK";
            }else {
                msg ="username error!";
            }
        }
        if (null != pwd){
            if ("pwd123456".equals(pwd)){
                msg ="OK";
            }else {
                msg ="password error!";
            }
        }
        return msg;
    }

}
