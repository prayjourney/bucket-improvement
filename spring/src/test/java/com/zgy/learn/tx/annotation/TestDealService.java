package com.zgy.learn.tx.annotation;

import com.zgy.learn.tx.annotation.service.AccountService;
import com.zgy.learn.tx.annotation.service.BookService;
import com.zgy.learn.tx.annotation.service.DealService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/13 3:06
 * @Modified by:
 */
public class TestDealService {
    ApplicationContext context = null;
    AccountService accountService = null;
    BookService bookService = null;
    DealService dealService = null;

    {
        context = new ClassPathXmlApplicationContext("classpath:spring-tx-annotation.xml");
        accountService = (AccountService) context.getBean("accountService");
        bookService = (BookService) context.getBean("bookService");
        dealService = (DealService) context.getBean("dealService");
    }

    @Test
    public void testBuyBook() throws Exception {
        dealService.buyBook(1, 1, 2);
    }
}
