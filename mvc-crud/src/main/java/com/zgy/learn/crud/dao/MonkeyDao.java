package com.zgy.learn.crud.dao;


import com.zgy.learn.crud.entities.Monkey;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-24 03:27
 * @Modified by:
 */
@Repository
public class MonkeyDao {
    static Map<Integer, Monkey> monkeys = new HashMap<>();
    private Integer INITID = 3;

    static {
        monkeys.put(1, new Monkey(1, "孫悟空", 1, LocalDate.of(582, 3, 22)));
        monkeys.put(2, new Monkey(2, "小猴子", 1, LocalDate.of(2009, 11, 7)));
        monkeys.put(3, new Monkey(3, "MMOPZB", 1, LocalDate.of(1973, 6, 8)));
    }

    public Collection getMonkeys() {
        return monkeys.values();
    }

    public Monkey get(Integer id) {
        return monkeys.get(id);
    }

    public int add(Monkey monkey) {
        monkeys.put(INITID, monkey);
        INITID++;
        return 1;
    }

    public int update(Integer id, Monkey monkey) {
        Monkey old = monkeys.get(id);
        monkeys.replace(id, old, monkey);
        return 1;
    }

    public int delete(Integer id) {
        monkeys.remove(id);
        return 1;
    }

}