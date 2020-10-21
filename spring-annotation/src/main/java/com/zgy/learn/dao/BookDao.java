package com.zgy.learn.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/27 17:18
 * @Modified by:
 */
// 名字默认是类名首字母小写, 此处注册的bean是bookDao
// @Primary, 这样有多个bean的时候， 就把他设置为首选注入的bean
@Repository
public class BookDao {

    private String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDao [lable=" + lable + "]";
    }
}
