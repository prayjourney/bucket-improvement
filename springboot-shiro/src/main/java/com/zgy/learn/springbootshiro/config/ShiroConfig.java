package com.zgy.learn.springbootshiro.config;

import com.zgy.learn.springbootshiro.realm.MyRealm;
import com.zgy.learn.springbootshiro.realm.MySha1Realm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
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
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
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

        filterMap.put("/index", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/index.html", "anon");
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
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myFirstRealm") MyRealm myFirstRealm,
                                                                  @Qualifier("mySha1Realm") MySha1Realm mySha1Realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联realm, 这是单个的Realm的情况
        // securityManager.setRealm(myFirstRealm);

        // 去除和mySha1Realm相关的内容，就是一个realm的情况
        ArrayList<Realm> realms = new ArrayList<>();
        realms.add(myFirstRealm);
        realms.add(mySha1Realm);
        securityManager.setRealms(realms);
        return securityManager;
    }

    /**
     * 创建自定义的Realm, 替换了原始的加密方式，改成了新的hashedCredentialsMatcher()的方式，MD5， 加密1024次数。
     */
    @Bean(name = "myFirstRealm")
    public MyRealm getRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher hashedCredentialsMatcher) {
        MyRealm mr = new MyRealm();
        mr.setCredentialsMatcher(hashedCredentialsMatcher);
        return mr;
    }

    @Bean(name = "mySha1Realm")
    public MySha1Realm getMySha1Realm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher
                                              hashedCredentialsMatcher) {
        MySha1Realm msr = new MySha1Realm();
        msr.setCredentialsMatcher(hashedCredentialsMatcher);
        return msr;
    }

    /**
     * 盐值加密算法和次数
     *
     * @return
     */
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5"); // 散列算法
        hashedCredentialsMatcher.setHashIterations(1024); // 散列次数
        return hashedCredentialsMatcher;
    }
}
