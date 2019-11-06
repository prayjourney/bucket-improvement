package com.zgy.learn.viewresolver;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description: 自定义视图, 我们需要配置一个视图解析器, 自动生成了一个页面, 我们没有给他一个jsp的页面
 * @Date: 2019-11-07 04:15
 * @Modified by:
 */
@Component
public class HelloView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.getWriter().print("hello , 我是一个Hello View, 自定义的 ," + LocalDateTime.now());

    }
}
