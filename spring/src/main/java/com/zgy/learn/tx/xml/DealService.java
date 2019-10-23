package com.zgy.learn.tx.xml;

/**
 * @Author: renjiaxin
 * @Despcription: 购买书籍的服务类， 没有具体的对应实体， 这个需要注意购买书籍的过程，就是一个完整的业务流程的思考模式，需要重点注意
 * @Date: Created in 2019/10/13 1:09
 * @Modified by:
 */
// 默认的bean是dealService

public class DealService {
    AccountService accountService;
    BookService bookService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

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
                // 更新账户余额
                accountService.updateBalance(id, count);
                System.out.println("购买成功！");
            } else {
                throw new Exception("库存不够！");
            }
        } else {
            throw new Exception("查无此书！");
        }

    }

    /**
     * 分两个步骤买书，先检查书的isbn, 检查库存，更新库存，okay后返回总价
     * 然后，检查账户id, 获取余额，更新余额，然后返回购买成功的标志
     *
     * @param id     购买者的余额id
     * @param isbn   书籍的isbn号
     * @param number 购买书籍的数量
     */

    public void buyBookTwoStep(int id, int isbn, int number) throws Exception {
        double no = bookService.buyTheBookByIsbn(isbn, number);
        int result = accountService.payForBookById(id, no);
        if (result == 1) {
            System.out.println("购买成功！");
        }else {
            System.out.println("购买失败！");
        }


    }
}
