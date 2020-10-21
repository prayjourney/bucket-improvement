package com.zgy.learn.crud.dao;

import com.zgy.learn.crud.entities.Animal;
import com.zgy.learn.crud.entities.Student;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-22 02:16
 * @Modified by:
 */
@Repository
public class AnimalDao {
    private static Map<Integer, Animal> animals = new HashMap<>();
    static int INITID = 4;

    static {
        animals.put(1, new Animal(1, "熊猫", LocalDate.of(2019, 2, 3), "China"));
        animals.put(2, new Animal(2, "美洲虎", LocalDate.of(2006, 12, 23), "USA"));
        animals.put(3, new Animal(3, "蜜獾", LocalDate.of(2019, 9, 8), "Zambia"));
        //animals.put(1, new Animal(1, "熊猫", "2009-1-2", "China"));
        //animals.put(2, new Animal(2, "美洲虎", "1992-1-2", "USA"));
        //animals.put(3, new Animal(3, "蜜獾", "2016-12-23", "Zambia"));
    }

    public Collection<Animal> getAll() {
        return animals.values();
    }

    public int addAnimal(Animal animal) {
        animals.put(INITID, animal);
        INITID++;
        return 1;
    }

    public int delete(Integer id) {
        animals.remove(id);
        return 1;
    }

    public int update(Animal animal) {
        Integer id = animal.getId();
        animals.replace(id, animal);
        return 1;
    }

    public Animal get(Integer id) {
        return animals.get(id);
    }


}
