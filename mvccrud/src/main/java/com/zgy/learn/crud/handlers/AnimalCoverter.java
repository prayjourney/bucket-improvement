package com.zgy.learn.crud.handlers;

import com.zgy.learn.crud.entities.Animal;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-22 02:51
 * @Modified by:
 */
@Component
public class AnimalCoverter implements Converter<String, Animal> {
    @Override
    public Animal convert(String s) {
        Animal animal = null;
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;

        if (null != s) {
            String[] vals = s.split("-");
            if (null != vals && vals.length == 4) {
                Integer id = Integer.parseInt(vals[0]);
                String name = vals[1];
                LocalDate birthday = LocalDate.from(dtf.parse(vals[2]));
//                String birthday = vals[2];
                String country = vals[3];
                System.out.println("完成了转换!");
                animal = new Animal(id, name, birthday, country);
            }
        }
        return animal;
    }
}
