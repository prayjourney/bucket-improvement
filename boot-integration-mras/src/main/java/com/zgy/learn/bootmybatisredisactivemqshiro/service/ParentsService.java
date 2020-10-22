package com.zgy.learn.bootmybatisredisactivemqshiro.service;

import com.zgy.learn.bootmybatisredisactivemqshiro.mapper.ParentsMapper;
import com.zgy.learn.bootmybatisredisactivemqshiro.pojo.Parents;
import com.zgy.learn.bootmybatisredisactivemqshiro.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ParentsService {
    @Autowired(required = false)
    ParentsMapper mapper;

    public Parents getParentsById(Integer parentsId) {
        return mapper.getParentsById(parentsId);
    }

    public int addParents(Map<String, Object> map) {
        return mapper.addParents(map);
    }

    public int deleteParents(Integer parentId) {
        return mapper.deleteParents(parentId);
    }

    public int updateParents(Integer parentsId, String fatherName, String motherName) {
        return mapper.updateParents(parentsId, fatherName, motherName);
    }

    public Parents getParentsByFatherMother(String fatherName, String motherName) {
        return mapper.getParentsByFatherMother(fatherName, motherName);
    }

    public List<Student> getParentsKids1(Integer parentsId) {
        return mapper.getParentsKids1(parentsId);
    }

    public List<Student> getParentsKids2(Integer parentsId) {
        return mapper.getParentsKids2(parentsId);
    }


}
