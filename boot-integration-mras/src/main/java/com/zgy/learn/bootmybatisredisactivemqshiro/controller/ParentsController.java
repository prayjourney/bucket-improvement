package com.zgy.learn.bootmybatisredisactivemqshiro.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zgy.learn.bootmybatisredisactivemqshiro.pojo.Parents;
import com.zgy.learn.bootmybatisredisactivemqshiro.service.ActiveMQService;
import com.zgy.learn.bootmybatisredisactivemqshiro.service.ParentsService;
import com.zgy.learn.bootmybatisredisactivemqshiro.service.RedisService;
import com.zgy.learn.bootmybatisredisactivemqshiro.utils.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("parents")
public class ParentsController {
    @Autowired
    ParentsService service;

    @Autowired
    private RedisService redisService;

    @Autowired
    ActiveMQService activeMQService;

    @GetMapping("getparents")
    public String getParentsById(Integer parentsId) throws JsonProcessingException {
        // activeMQService.createTopic("test");
        // 先到缓存之中查，如果没有然后到数据库中查询并且缓存到缓存之中
        if (redisService.hasKey(String.valueOf(parentsId))) {
            log.info("redis之中有该数据，key是{}", parentsId);
            activeMQService.sendMessage("获取父母信息！===");
            return JSONUtil.getJsonFromObject(redisService.get(String.valueOf(parentsId)) + "===》redis中获取!");
        } else {
            Parents p = service.getParentsById(parentsId);
            log.info("redis之中没有该数据，需要从数据库之中查询，然后写入redis数据库之中", parentsId);
            redisService.set(String.valueOf(parentsId), p);
            return JSONUtil.getJsonFromObject(p + "===》从数据库之中获取，并且缓存到redis之中!");
        }
    }

    @PostMapping("add")
    public String addParents(String fatherName, String motherName) throws JsonProcessingException {
        // activeMQService.createTopic("test");
        Map<String, Object> map = new HashMap<>();
        map.put("fatherName", fatherName);
        map.put("motherName", motherName);
        // 添加到缓存之中， 简单使用
        int result = service.addParents(map);
        if (result == 1) {
            Parents p = service.getParentsByFatherMother(fatherName, motherName);
            redisService.set(String.valueOf(p.getParentsId()), p);
            log.info("添加用户成功，已经添加到缓存之中! 时间是：{}", LocalDateTime.now());
            activeMQService.sendMessage("创建用户成功！===");
            return JSONUtil.getJsonFromObject("添加用户成功，已经添加到缓存之中!");
        } else if (result == 0) {
            log.error("添加用户失败! 时间是：{}", LocalDateTime.now());
            return JSONUtil.getJsonFromObject("添加用户失败!");
        } else {
            log.error("发生错误! 时间是：{}", LocalDateTime.now());
            return JSONUtil.getJsonFromObject("发生错误!");
        }
    }

    @PostMapping("delete")
    public String deleteParents(Integer parentsId) throws JsonProcessingException {
        // activeMQService.createTopic("test");
        if (redisService.hasKey(String.valueOf(parentsId))) {
            // 先删除redis缓存，然后删除数据库值
            redisService.del(String.valueOf(parentsId));
            service.deleteParents(parentsId);
            log.warn("删除redis缓存, 删除了数据库值! 时间是：{}", LocalDateTime.now());
            activeMQService.receiveMessage();
            return JSONUtil.getJsonFromObject("删除redis缓存, 删除了数据库值!");
        } else {
            service.deleteParents(parentsId);
            log.warn("删除了数据库值! 时间是：{}", LocalDateTime.now());
            return JSONUtil.getJsonFromObject("删除了数据库值!");
        }
    }

    @PostMapping("update")
    public String updateParents(Integer parentsId, String fatherName, String motherName) throws JsonProcessingException {
        return JSONUtil.getJsonFromObject(service.updateParents(parentsId, fatherName, motherName));
    }

    @GetMapping("getbyname")
    public String getParentsByFatherMother(String fatherName, String motherName) throws JsonProcessingException {
        return JSONUtil.getJsonFromObject(service.getParentsByFatherMother(fatherName, motherName));
    }

    @GetMapping("kids1")
    public String getParentsKids(Integer parentsId) throws JsonProcessingException {
        return JSONUtil.getJsonFromObject(service.getParentsKids1(parentsId));
    }

    @GetMapping("kids2")
    public String getParentsKidsById2(Integer parentsId) throws JsonProcessingException {
        return JSONUtil.getJsonFromObject(service.getParentsKids2(parentsId));
    }
}