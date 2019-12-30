package com.zgy.learn.service;

import com.zgy.learn.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/27 17:18
 * @Modified by:
 */
@Service
public class BookService {
    //@Qualifier("bookDao")
    @Autowired(required = false)
    private BookDao bookDao;

    public void print(){
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService [bookDao=" + bookDao + "]";
    }
}
