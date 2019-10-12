package com.zgy.learn.tx.annotation.dao;

import com.zgy.learn.tx.annotation.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/13 1:09
 * @Modified by:
 */
@Repository(value = "bookDao")
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    Book book;

    /**
     * 检查仓库之中是否有此书
     *
     * @return false无此书，true有此书
     */
    public boolean checkIsbn(int isbn) {
        String sql = "select count(isbn) from book where isbn = ?";
        RowMapper<Integer> rm = new SingleColumnRowMapper<>(Integer.class);
        int result = jdbcTemplate.queryForObject(sql, rm, isbn);
        if (result <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 通过isbn获取书籍的库存量
     *
     * @param isbn isbn
     * @return 书籍库存
     */
    public int queryBookStockByIsbn(int isbn) {
        String sql = "select stock from book where isbn =?";
        RowMapper<Integer> rm = new SingleColumnRowMapper<>(Integer.class);
        return jdbcTemplate.queryForObject(sql, rm, isbn);
    }

    /**
     * 通过isbn来获取书籍价格
     *
     * @param isbn
     * @return
     */
    public double queryBookPriceByIsbn(int isbn) {
        String sql = "select price from book where isbn = ?";
        RowMapper<Double> rm = new SingleColumnRowMapper<>(Double.class);
        return jdbcTemplate.queryForObject(sql, rm, isbn);
    }

    /**
     * 更新库存
     *
     * @param isbn  isbn
     * @param stock 库存
     */
    public void updateStockByIsbn(int isbn, int stock) {
        String sql = "update book set stock =? where isbn =?";
        jdbcTemplate.update(sql, stock, isbn);

    }
}

