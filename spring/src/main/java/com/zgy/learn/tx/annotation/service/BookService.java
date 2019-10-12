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
// 默认的bean名字叫做bookService
@Service
public class BookService {
    @Autowired
    BookDao bookDao;


    /**
     * 检查仓库之中是否有此书
     *
     * @return false无此书，true有此书
     */
    public boolean checkIsbn(int isbn) {
        return bookDao.checkIsbn(isbn);

    }

    /**
     * 通过isbn获取书籍的库存量
     *
     * @param isbn isbn
     * @return 书籍库存
     */
    public int queryBookStockByIsbn(int isbn) {
        return bookDao.queryBookStockByIsbn(isbn);
    }

    /**
     * 通过isbn来获取书籍价格
     *
     * @param isbn
     * @return 价格
     */
    public double queryBookPriceByIsbn(int isbn) {
        return bookDao.queryBookPriceByIsbn(isbn);
    }

    /**
     * 更新库存
     *
     * @param isbn  isbn
     * @param stock 库存
     */
    public void updateStockByIsbn(int isbn, int stock) {
        bookDao.updateStockByIsbn(isbn, stock);
    }
}

