package com.zgy.learn.crud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-13 01:41
 * @Modified by:
 */
@Data
@AllArgsConstructor
public class Student {
    private String name;
    private Integer age;
    private String gender;
    private String classId;
    private String gradeName;
    private String email;
    private String phoneNumber;
    private LocalDate birth;

}
