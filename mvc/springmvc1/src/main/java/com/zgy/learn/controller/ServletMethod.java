package com.zgy.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description: 使用servlet支持的方法
 * @Date: 2019-11-05 12:51
 * @Modified by:
 */
@Controller
@RequestMapping("servlet")
public class ServletMethod {
    @RequestMapping("setcookie")
    public String testHttpRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("JSESSIONID", "123ewqeqweqeq");
        Cookie cookie = new Cookie("JSESSIONID", request.getMethod());
        response.addCookie(cookie);
        return "servletmethod";
    }


    @RequestMapping("apitest")
    public String testAPIServlet(HttpServletRequest request, HttpServletResponse response, Writer writer)
            throws IOException {
        System.out.println("testAPIServlet" + request + "," + response);
        writer.write("12345");
        return "servletmethod";
    }

    @RequestMapping("session")
    public String testServletSession(HttpServletRequest request, HttpSession servletSession, Map<String, String> mp)
            throws IOException {
        // 使用session API
        System.out.println("testAPIServlet" + request + "," + servletSession);
        System.out.println("session的名称:"+servletSession.getAttributeNames());
        mp.put("sessionID", servletSession.getId());
        return "servletmethod";
    }
}
