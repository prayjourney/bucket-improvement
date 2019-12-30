package com.zgy.learn.config;

import com.zgy.learn.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/30 14:22
 * @Modified by:
 */
@Configuration
@ComponentScan(value = {"com.zgy.learn.bean", "com.zgy.learn.config", "com.zgy.learn.dao"})
public class MainConfigAutowired {

    //此处注册的bean是bookDao2, 所以当前有两个bean
    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }
}
