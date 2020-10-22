package com.zgy.learn.bootmybatisredisactivemqshiro.mapper;

import com.zgy.learn.bootmybatisredisactivemqshiro.pojo.Souvenir;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/4/26 23:08
 * @Modified by:
 */
@Mapper
public interface CityMapper {
    /**
     * 一个城市，对应多个特产，1对多
     * @param soName 城市名称
     * @return list
     */
    public List<Souvenir> getSouvenirByName(String soName);
}
