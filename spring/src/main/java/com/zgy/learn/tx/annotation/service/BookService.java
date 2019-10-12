package com.zgy.learn.tx.annotation.service;

import com.zgy.learn.tx.annotation.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/13 1:08
 * @Modified by:
 */
@Service
public class BookService {
    @Autowired
    BookDao bookDao;


    public boolean checkIsbn(int isbn) {
        return bookDao.checkIsbn(isbn);

    }

    public int queryBookStockByIsbn(int isbn) {
        return bookDao.queryBookStockByIsbn(isbn);
    }

    public double queryBookPriceByIsbn(int isbn) {
        return bookDao.queryBookPriceByIsbn(isbn);
    }

    public void updateStockByIsbn(int isbn, int stock) {
        bookDao.updateStockByIsbn(isbn, stock);
    }
}

