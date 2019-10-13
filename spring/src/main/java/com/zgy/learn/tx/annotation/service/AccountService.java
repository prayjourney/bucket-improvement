package com.zgy.learn.tx.annotation.service;

import com.zgy.learn.tx.annotation.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: renjiaxin
 * @Despcription: AccountService
 * @Date: Created in 2019/10/13 1:07
 * @Modified by:
 */
@Service(value = "accountService")
public class AccountService {
    @Autowired
    AccountDao accountDao;

    /**
     * 检查是否有这个账户
     *
     * @param id id
     * @return false没有此id, true有此账户
     */
    public boolean checkID(int id) {
        boolean s = accountDao.checkID(id);
        return s;
    }

    /**
     * 通过id获取余额
     *
     * @param id id
     * @return 余额
     */
    public double getBalance(int id) {
        double balance = accountDao.getBalance(id);
        return balance;
    }

    /**
     * 更新余额
     *
     * @param id
     * @param nu
     */
    public void updateBalance(int id, double nu) {
        accountDao.updateBalance(id, nu);
    }

    /**
     * 为购买的书，付钱，余额和总的金额之间的关系
     *
     * @param id           账户id
     * @param countCashier 总的金额
     * @return 返回执行结果
     */
    public int payForBookById(int id, double countCashier) throws Exception {
        int result = accountDao.payForBookById(id, countCashier);
        return result;
    }
}
