package com.zgy.learn.bootmybatisredisactivemqshiro.mapper;

import com.zgy.learn.bootmybatisredisactivemqshiro.pojo.Parents;
import com.zgy.learn.bootmybatisredisactivemqshiro.pojo.Student;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

@Mapper
public interface ParentsMapper {
    @Select("select parentsId, fatherName, motherName from parents where parentsId = #{parentsId}")
    @Results({
            @Result(column = "parentsId", property = "parentsId"),
            @Result(column = "fatherName", property = "fatherName"),
            @Result(column = "motherName", property = "motherName")
    })
    Parents getParentsById(Integer parentsId);

    /**
     * 增删改，返回的都是受影响的行数，只有查返回的是需要的数据
     */
    int addParents(Map<String, Object> map);

    int deleteParents(Integer parentId);

    int updateParents(Integer parentsId, String fatherName, String motherName);

    Parents getParentsByFatherMother(String fatherName, String motherName);

    // 完整的sql语句，此处是分成了两个步骤，有点麻烦， 此处写这个需要把一句话拆成两个部分，有点麻烦
    //    @Select("select p.parentsId pId, p.fatherName fName, p.motherName mName, s.stId sId, s.stName sName,
    //          s.stAge sAge, s.stGender sGender, s.stClass sClass, s.stHome sHome from parents as p
    //          left join student as s on s.parentsId = p.parentsId where parentsId =#{parentsId}")
    //    @Results(value = {
    //            @Result(property = "parentsId", column = "pId"),
    //            @Result(property = "fatherName", column = "fName"),
    //            @Result(property = "motherName", column = "mName"),
    //            @Result(property = "kids", column = "mName"),
    //    })
    //    public List<Student> getParentsKids(Integer parentsId);

    // https://www.freesion.com/article/287765857/
    @Select("select parentsId, fatherName, motherName from parents where parentsId =#{parentsId}")
    @Results(value = {
            @Result(property = "parentsId", column = "parentsId"),
            @Result(property = "fatherName", column = "fatherName"),
            @Result(property = "motherName", column = "motherName"),
            // https://www.freesion.com/article/287765857/
            // column = "stParentsId": 表示拿着parents表中的主键stParentsId，去查询student表
            // 此处的column是什么意思，从哪儿来的， column = "stParentsId",
            @Result(property = "kids", javaType = List.class, column = "parentsId",
                    many = @Many(select = "com.zgy.learn.bootmybatisredisactivemq.mapper.ParentsMapper.getStudentInfoByParentsId",
                            fetchType = FetchType.LAZY))
    })
    List<Student> getParentsKids1(Integer parentsId);

    @Select("select stId, stName, stAge, stGender, stClass, stHome, stParentsId from student where stParentsId = #{stParentsId}")
    @Results({
            @Result(property = "stId", column = "stId"),
            @Result(property = "stName", column = "stName"),
            @Result(property = "stAge", column = "stAge"),
            @Result(property = "stGender", column = "stGender"),
            @Result(property = "stClass", column = "stClass"),
            @Result(property = "stHome", column = "stHome"),
            @Result(property = "stParentsId", column = "stParentsId"),
    })
    List<Student> getStudentInfoByParentsId(Integer stParentsId);


    List<Student> getParentsKids2(Integer parentsId);


    /***
     *     @Select("select * from parents")
     *     @Results({
     *             @Result(column = "parentsId", property = "parentsId"),
     *             //column = "id":表示拿着category表中的主键id，去查询product表
     *             @Result(column = "parentsId", property = "kid", javaType = List.class,
     *                     many = @Many(select = "com.zgy.learn.bootmybatisredisactivemq.mapper.ParentsMapper.getStudentInfoByParentsId"))
     *     })
     *     List<Student> getParentsKids1(Integer parentsId);
     *
     *     @Select("select * from student where stParentsId = #{stParentsId}")
     *     List<Student> getStudentInfoByParentsId(Integer stParentsId);
     */
}
