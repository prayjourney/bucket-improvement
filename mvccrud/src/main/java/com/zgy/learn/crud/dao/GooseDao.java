package com.zgy.learn.crud.dao;

import com.zgy.learn.crud.entities.Goose;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-26 01:26
 * @Modified by:
 */
@Repository
public class GooseDao {
    static Map<Integer, Goose> gooses = new HashMap<>();
    private Integer INITID = 4;

    static {
        gooses.put(1, new Goose(1, "北京鵝", "差"));
        gooses.put(2, new Goose(2, "北海道鵝", "良"));
        gooses.put(3, new Goose(3, "加拿大鵝", "優"));
    }

    public Collection getGooses() {
        return gooses.values();
    }

    public Goose get(Integer id) {
        return gooses.get(id);
    }

    public int add(Goose goose) {
        gooses.put(INITID, goose);
        INITID++;
        return 1;
    }

    public int update(Integer id, Goose goose) {
        Goose old = gooses.get(id);
        gooses.replace(id, old, goose);
        return 1;
    }

    public int delete(Integer id) {
        gooses.remove(id);
        return 1;
    }

}
