package com.zgy.learn.tx.annotation.service;

import com.zgy.learn.tx.annotation.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/13 1:07
 * @Modified by:
 */
@Service(value = "accountService")
public class AccountService {
    @Autowired
    AccountDao accountDao;

    public boolean checkID(int id) {
        boolean s = accountDao.checkID(id);
        return s;
    }

    public double getBalance(int id) {
        double balance = accountDao.getBalance(id);
        return balance;
    }

    public void updateBalance(int id, double nu) {
        accountDao.updateBalance(id, nu);
    }
}
