package com.zgy.learn.bootcrud.filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/17 2:27
 * @Modified by:
 */
public class MyFilter extends HttpFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException, IOException {
        System.out.println("MyFilter process...");
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
