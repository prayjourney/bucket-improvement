package com.zgy.learn.bootmybatisredisactivemqshiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Parents {
    private Integer parentsId;
    private String fatherName;
    private String motherName;

    private List<Student> kids;
}
