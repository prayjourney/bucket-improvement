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
public class City {
    private Integer ctId;
    private String ctName;
    private String ctProvince;
    /**
     * 城市生产的纪念品
     */
    private List<Souvenir> souvenirs;
}
