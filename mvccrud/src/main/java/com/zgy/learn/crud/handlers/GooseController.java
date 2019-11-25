package com.zgy.learn.crud.handlers;

import com.zgy.learn.crud.dao.GooseDao;
import com.zgy.learn.crud.entities.Goose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-26 01:30
 * @Modified by:
 */
@Controller
@RequestMapping(value = "goose")
public class GooseController {
    @Autowired
    GooseDao dao;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String getAllMonkey(ModelMap modelMap) {
        modelMap.addAttribute("gooses", dao.getGooses());
        return "gooses";
    }

    /**
     * 跳轉到表單
     *
     * @return
     */
    @RequestMapping("add")
    public String addGoose() {
        return "addgoose";
    }

    /**
     * 真正添加一個鵝
     *
     * @param goose
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addMonkey(Goose goose) {
        dao.add(goose);
        return "redirect:/goose/all";
    }

    /**
     * 删除一只鹅
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public String deleteGoose(@PathVariable Integer id) {
        // id 不能修改
        dao.delete(id);
        return "redirect:/goose/all";
    }

    /**
     * 跳轉到更新頁面
     *
     * @param id
     * @param mp
     * @return
     */
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateGoose(@PathVariable Integer id, ModelMap mp) {
        // 為了回顯數據
        Goose goose = dao.get(id);
        mp.addAttribute("oldgoose", goose);
        return "updategoose";
    }


    /**
     * 真正更新數據
     *
     * @param id
     * @param goose
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public String updateGoose(Integer id, Goose goose) {
        // id 不能修改
        dao.update(id, goose);
        return "redirect:/goose/all";
    }


}
