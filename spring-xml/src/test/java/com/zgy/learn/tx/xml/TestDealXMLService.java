package com.zgy.learn.tx.xml;

import com.zgy.learn.tx.xml.service.AccountService;
import com.zgy.learn.tx.xml.service.BookService;
import com.zgy.learn.tx.xml.service.DealService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/13 3:06
 * @Modified by:
 */
public class TestDealXMLService {
    ApplicationContext context = null;
    AccountService accountService = null;
    BookService bookService = null;
    DealService dealService = null;

    {
        context = new ClassPathXmlApplicationContext("classpath:spring-tx-usexml.xml");
        accountService = (AccountService) context.getBean("accountCardService");
        bookService = (BookService) context.getBean("bookShopService");
        dealService = (DealService) context.getBean("dealService");
    }

    @Test
    public void testBuyBook() throws Exception {
        dealService.buyBook(1, 1, 2);
    }

    @Test
    public void testBuyBook2() throws Exception {
        dealService.buyBookTwoStep(1, 2, 1);
    }

}
