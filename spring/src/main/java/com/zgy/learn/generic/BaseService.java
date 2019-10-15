package com.zgy.learn.generic;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: renjiaxin
 * @Despcription: 泛型依赖注入
 * @Date: Created in 2019/10/16 0:28
 * @Modified by:
 */
public class BaseService<T> {
    @Autowired
    protected BaseRepository<T> re;

    public void add() {
        System.out.println("add...");
        System.out.println(re);
    }
}
