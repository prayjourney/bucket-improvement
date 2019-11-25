package com.zgy.learn.crud.handlers;

import com.zgy.learn.crud.dao.MonkeyDao;
import com.zgy.learn.crud.entities.Monkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-25 12:57
 * @Modified by:
 */
@Controller
@RequestMapping(value = "monkey")
public class MonkeyController {
    @Autowired
    MonkeyDao dao;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String getAllMonkey(ModelMap modelMap) {
        modelMap.addAttribute("monkeys", dao.getMonkeys());
        return "monkeys";
    }

    /**
     * 跳轉到表單
     *
     * @return
     */
    @RequestMapping("add")
    public String addMonkey() {
        return "addmonkey";
    }

    /**
     * 真正添加一個猴子
     *
     * @param monkey
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    // 這樣可以
    // public String addMonkey(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("gender") Integer gender,
    //        @RequestParam("birthday") LocalDate birthday) {

    // 這樣可以
    // public String addMonkey(Integer id, String name, Integer gender, @RequestParam("birthday") LocalDate birthday) {
    //        Monkey monkey = new Monkey(id, name, gender, birthday);


    // 這樣不可以
    // public String addMonkey(@RequestParam("monkey") Monkey monkey) {
    //       dao.add(monkey);

    // 這樣可以, 說明有自動裝箱
    public String addMonkey(Monkey monkey) {
        dao.add(monkey);
        return "redirect:/monkey/all";
    }


    /**
     * 注册一个类型解析器
     * 该注解会在该Controller初始化的时候注册一个转换器（属性编辑器）
     * @param binder
     */
    //    @InitBinder
    //    public void initBinder(WebDataBinder binder){
    //        // WebDataBinder是Spring提供的支持, 表示DateEditor的目标类型是Date
    //        binder.registerCustomEditor(Date.class, new DateEditor());
    //    }
}