package com.zgy.learn.tx.xml.service;

import com.zgy.learn.tx.xml.BookDao;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/13 1:08
 * @Modified by:
 */
public class BookService {
    BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

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

    /**
     * 买书，此处要关心的是书的库存和我们要购买的数量之间的关系， 如果不够，那就执行不成功，这看成是一个事务
     *
     * @param isbn   isbn
     * @param number number
     * @return 返回总价
     */
    public double buyTheBookByIsbn(int isbn, int number) throws Exception {
        double no = bookDao.buyTheBookByIsbn(isbn, number);
        return no;
    }
}

