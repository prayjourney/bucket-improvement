package com.zgy.learn.bootmybatisredisactivemqshiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    // id
    private Integer stId;
    // 姓名
    private String stName;
    // 年龄
    private Integer stAge;
    // 手机
    private String stPhoneNo;
    // 性别
    private String stGender;
    // 班级
    private String stClass;
    // 家庭住址
    private String stHome;
    // 父母ID
    private Integer stParentsId;
}
