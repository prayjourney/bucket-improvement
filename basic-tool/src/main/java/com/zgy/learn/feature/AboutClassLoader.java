package com.zgy.learn.feature;

import java.net.URL;

/**
 * @Author: renjiaxin
 * @Despcription: 关于类加载器
 * @Date: Created in 2020/2/28 22:33
 * @Modified by:
 */
public class AboutClassLoader {
    public static void main(String[] args) {
        AboutClassLoader ccc = new AboutClassLoader();
        ClassLoader classLoader = ccc.getClass().getClassLoader();
        System.out.println(classLoader.getClass().getName());
        // sun.misc.Launcher$AppClassLoader

        System.out.println("===============");
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }

    }
}


