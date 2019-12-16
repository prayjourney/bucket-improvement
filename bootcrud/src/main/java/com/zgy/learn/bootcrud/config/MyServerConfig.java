package com.zgy.learn.bootcrud.config;

import com.zgy.learn.bootcrud.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/17 2:19
 * @Modified by:
 */
@Configuration
public class MyServerConfig {
    // 注册我们的Servlet
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(new MyServlet());
        registrationBean.setUrlMappings(Arrays.asList("/myServlet"));
        registrationBean.setLoadOnStartup(1);
        return registrationBean;

    }
}
