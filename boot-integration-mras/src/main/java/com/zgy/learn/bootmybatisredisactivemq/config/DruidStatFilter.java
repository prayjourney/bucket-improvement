package com.zgy.learn.bootmybatisredisactivemq.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * https://www.jianshu.com/p/c3006ac7e37c
 * druid过滤器
 * <p>
 * WebStatFilter用于采集web-jdbc关联监控的数据。
 * 属性filterName声明过滤器的名称,可选
 * 属性urlPatterns指定要过滤 的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*", initParams = {
        // 忽略资源
        @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
})
public class DruidStatFilter extends WebStatFilter {
}
