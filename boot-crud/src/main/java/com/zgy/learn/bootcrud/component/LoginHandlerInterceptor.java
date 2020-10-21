package com.zgy.learn.bootcrud.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: renjiaxin
 * @Despcription: denglu 登录拦截器
 * @Date: Created in 2019/12/14 16:06
 * @Modified by:
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("loginUser");
        if (StringUtils.isEmpty(username)) {
            // 没有登录， 转回到登录页面
            request.setAttribute("msg", "没有权限！");
            request.getRequestDispatcher("/login.html").forward(request, response);
            return false;
        } else {
            // 登录， 放行
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
