package com.zgy.learn.tx.xml;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;

/**
 * @Author: renjiaxin
 * @Despcription: AccountDao
 * @Date: Created in 2019/10/13 1:09
 * @Modified by:
 */

public class AccountDao {

    private Account account;

    private JdbcTemplate jdbcTemplate;

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    /**
     * 检查是否有这个账户
     *
     * @param id id
     * @return false没有此id, true有此账户
     */
    public boolean checkID(int id) {
        String sql = "select id from account where id =?";
        RowMapper<Integer> rw = new SingleColumnRowMapper<>(Integer.class);
        int result = jdbcTemplate.queryForObject(sql, rw, id);
        if (result <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 通过id获取余额
     *
     * @param id id
     * @return 余额
     */
    public double getBalance(int id) {
        String sql = "select balance from account where id =?";
        RowMapper<Double> rw = new SingleColumnRowMapper<>(Double.class);
        return jdbcTemplate.queryForObject(sql, rw, id);
    }

    /**
     * 更新余额
     *
     * @param id
     * @param nu
     */
    public void updateBalance(int id, double nu) {
        String sql = "update account set balance = ? where id =?";
        jdbcTemplate.update(sql, nu, id);
    }


    /**
     * 为购买的书，付钱，余额和总的金额之间的关系
     *
     * @param id           账户id
     * @param countCashier 总的金额
     * @return 返回执行结果
     */
    public int payForBookById(int id, double countCashier) throws Exception {
        // 检查账户
        String checkId = "select count(id) from account where id = ?";
        RowMapper<Integer> rw = new SingleColumnRowMapper<>(Integer.class);
        int idCount = jdbcTemplate.queryForObject(checkId, rw, id);
        if (idCount == 0) throw new Exception("账户不存在！");

        // 查询账户
        String balanceSql = "select balance from account where id = ?";
        RowMapper<Double> rw2 = new SingleColumnRowMapper<>(Double.class);
        double balance = jdbcTemplate.queryForObject(balanceSql, rw2, id);

        // 付钱
        if (balance - countCashier < 0) throw new Exception("余额不足！");
        String updateBalanceSql = "update account set balance = ? where id = ?";
        double newBalance = balance - countCashier;
        int result = jdbcTemplate.update(updateBalanceSql, newBalance, id);
        return result;
    }

}
