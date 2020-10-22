package com.zgy.learn.tools;

import org.springframework.util.FileSystemUtils;
import sun.security.util.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * @Author: renjiaxin
 * @Despcription: 操作properties文件
 * @Date: Created in 2020/2/7 15:28
 * @Modified by:
 */
public class OptProperties {
    public static void getPathTest() {
        // 取到绝对路径, 但是这个是target里面的, 带了file:
        URL is = Thread.currentThread().getContextClassLoader().getResource("myinfo.properties");
        System.out.println("--->URL is :" + is);
        String urlPath = is.getPath();
        System.out.println("===>urlPath is :" + urlPath);
        // 取到绝对路径, 但是这个是target里面的，去掉了file
        String path1 = OptProperties.class.getResource("/myinfo.properties").getPath();
        System.out.println("+++>paht1 is " + path1 + "\n");

        // 获取当前项目的路径, 自己拼接路径
        String property = System.getProperty("user.dir");
        System.out.println(property);
        String mypath = property + "\\basictool\\src\\main\\resources\\myinfo.properties";
        System.out.println(mypath);

        // 在target目录下的文件名
        String fileName = OptProperties.class.getClassLoader().getResource("\\myinfo.properties").getPath();
        System.out.println("fileName:=====:" + fileName);
    }

    public static void main(String[] args) {
        getPathTest();
        String property = System.getProperty("user.dir");
        String mypath = property + "\\basictool\\src\\main\\resources\\myinfo.properties";
        String mypathtemp = property + "\\basictool\\src\\main\\resources\\myinfotemp.properties";
        //System.out.println(mypath);
        //readProperties(mypath);
        writeProperties(mypath, mypathtemp);
        //readProperties2();
    }

    public static void readProperties(String name) {
        try {
            FileInputStream fis = new FileInputStream(name);
            Properties pro = new Properties();
            pro.load(fis);
            System.out.println(pro.getProperty("age"));
            System.out.println(pro.getProperty("name"));
            System.out.println(pro.getProperty("hello"));
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeProperties(String path, String path2) {
        try {
            // 读取
            FileInputStream fis = new FileInputStream(path);
            // 输出
            FileOutputStream fos = new FileOutputStream(path2);
            Properties pro = new Properties();
            Properties protemp = new Properties();
            pro.load(fis);
            fis.close();

            // 先放里面，然后修改
            protemp.putAll(pro);
            protemp.setProperty("hello", "123");
            protemp.store(fos, "write");
            fos.close();

            // 文件删除和改名
            File f1 = new File(path);
            File f2 = new File(path2);
            f1.delete();
            f2.renameTo(f1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 在pom文件下面添加了resources, 没啥作用啊
    public static void readProperties2() {
        try {
            FileInputStream fis = new FileInputStream("/myinfo2.properties");
            Properties pro = new Properties();
            pro.load(fis);
            System.out.println(pro.getProperty("age"));
            System.out.println(pro.getProperty("name"));
            System.out.println(pro.getProperty("tag"));
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
