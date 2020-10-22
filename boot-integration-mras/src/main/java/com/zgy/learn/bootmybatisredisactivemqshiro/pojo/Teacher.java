package com.zgy.learn.bootmybatisredisactivemqshiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher {
    // id
    private Integer teId;
    // 姓名
    private String teName;
    // 年龄
    private Integer teAge;
    // 手机
    private String tePhoneNo;
    // 性别
    private String teGender;
    // 教授班级
    private String teClass;
    // 教授科目
    private String teCourse;
    // 工作年限
    private Integer teWorkTime;

}
