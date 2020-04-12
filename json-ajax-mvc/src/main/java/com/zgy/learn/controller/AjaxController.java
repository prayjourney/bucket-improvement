package com.zgy.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

}
