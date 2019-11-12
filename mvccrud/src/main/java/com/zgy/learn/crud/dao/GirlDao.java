package com.zgy.learn.crud.dao;

import com.zgy.learn.crud.entities.Girl;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description: GirlDao
 * @Date: 2019-11-11 02:48
 * @Modified by:
 */
@Repository
public class GirlDao {
    private static Map<Integer, Girl> girls = null;
    private static int initId = 6;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    static {
        girls = new HashMap<>();
        girls.put(1, new Girl("文秀", 22, "A"));
        girls.put(2, new Girl("李云龙", 35, "B"));
        girls.put(3, new Girl("KrisTina", 28, "E"));
        girls.put(4, new Girl("小泽玛利亚", 32, "C"));
        girls.put(5, new Girl("刘亦菲", 22, "B"));
    }

    /**
     * 获取所有的女孩
     *
     * @return
     */
    public Collection<Girl> getGrils() {
        return girls.values();
    }

    /**
     * 添加一个女孩到集合 然后返回id
     *
     * @param name
     * @param age
     * @param size
     * @return
     */
    public int addGirl(String name, Integer age, String size, String birth, Float salary) {
        Girl g = new Girl(name, age, size);
        Date d = null;
        try {
            d = sdf.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        g.setBirth(d);
        g.setSalary(salary);
        girls.put(initId, g);
        int id = initId;
        initId++;
        return id;
    }


    /**
     * 删除一个女孩, 然后返回删除成功与否
     *
     * @param id
     * @return
     */
    public boolean deleteGirl(int id) {
        girls.remove(id);
        return true;
    }

    /**
     * 返回一个girl
     *
     * @param id
     * @return
     */
    public Girl getGirl(int id) {
        return girls.get(id);
    }

    /**
     *
     */
    public Girl updateGirl(int ID, String name, int age, String size) {
        Girl g = girls.get(ID);
        g.setAge(age);
        g.setName(name);
        g.setSize(size);
        girls.replace(ID, g);
        return g;
    }

}
