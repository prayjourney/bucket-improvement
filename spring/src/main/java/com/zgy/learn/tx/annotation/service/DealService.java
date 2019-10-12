package com.zgy.learn.tx.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/13 1:09
 * @Modified by:
 */
@Service
public class DealService {
    @Autowired
    AccountService accountService;

    @Autowired
    BookService bookService;

    /**
     * 购买书籍
     * 购买书籍的流程，通过isbn来购买，输入数量，如果isbn没有，则报错，如果有，则获取数量，和库存比较，
     * 如果库存不够，则购买失败， 如果库存够, 则减库存，然后，计算总的金额 ，获取购买者的账户余额，然后
     * 比较余额和购买需要的金额，如果金额够，则购买成功，否则购买失败，成功后，就发送提醒。
     * API设计：
     * BookService提供：
     * 1.查找isbn，2.通过isbn查找书籍库存量，3.通过isbn查询对应书籍的单价，4.更新库存， 5.提示购买成功
     * AccountService提供：
     * 1.查找id，  2.通过id来查找余额, 3.更新余额。
     *
     * @param id     购买者的余额id
     * @param isbn   书籍的isbn号
     * @param number 购买书籍的数量
     */
    @Transactional
    public void buyBook(int id, int isbn, int number) throws Exception {
        boolean s = bookService.checkIsbn(isbn);
        if (true == s) {
            int stock = bookService.queryBookStockByIsbn(isbn);
            double price = bookService.queryBookPriceByIsbn(isbn);
            if (stock - number > 0) {
                // 更新库存
                bookService.updateStockByIsbn(isbn, stock - number);
                boolean t = accountService.checkID(id);
                if (false == t) throw new Exception("查无此人！");
                double balance = accountService.getBalance(id);
                double count = balance - price * number;
                if (count < 0) throw new Exception("余额不够！");
                accountService.updateBalance(id, count);
                System.out.println("购买成功！");
            } else {
                throw new Exception("库存不够！");
            }
        } else {
            throw new Exception("查无此书！");
        }

    }
}
