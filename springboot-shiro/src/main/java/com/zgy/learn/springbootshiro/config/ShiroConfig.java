package com.zgy.learn.springbootshiro.config;

import com.zgy.learn.springbootshiro.realm.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Despcription: Shiro的配置类，关于Configuration的讲解，可参考一下博客：https://www.cnblogs.com/WUXIAOCHANG/p/10877266.html
 * @Date: Created in 2020/2/17 15:56
 * @Modified by:
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置 SecurityManager
        bean.setSecurityManager(securityManager);

        bean.setSuccessUrl("/list");
        // 设置登录跳转页面
        bean.setLoginUrl("/index");
        // 设置未授权提示页面
        bean.setUnauthorizedUrl("/404");
        /**
         * Shiro内置过滤器，可以实现拦截器相关的拦截器
         *    常用的过滤器：
         *      anon：无需认证（登录）可以访问
         *      authc：必须认证才可以访问
         *      user：如果使用rememberMe的功能可以直接访问
         *      perms：该资源必须得到资源权限才可以访问
         *      role：该资源必须得到角色权限才可以访问
         **/
        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/index","anon");
        filterMap.put("/login", "anon");
        filterMap.put("/index.html","anon");
        filterMap.put("/login.html", "anon");
//      filterMap.put("/vip/index", "roles[vip]");
        filterMap.put("/static/**", "anon");
        filterMap.put("/**", "authc");
        filterMap.put("/logout", "logout");

        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    /**
     * 创建DefaultWebSecurityManager, 里面主要定义了登录，创建subject，登出等操作
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myFirstRealm") MyRealm myFirstRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联realm
        securityManager.setRealm(myFirstRealm);
        return securityManager;
    }

    /**
     * 创建自定义的Realm
     */
    @Bean(name = "myFirstRealm")
    public MyRealm getRealm() {
        return new MyRealm();
    }
}
