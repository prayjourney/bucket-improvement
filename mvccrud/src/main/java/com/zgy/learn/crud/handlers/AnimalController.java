package com.zgy.learn.crud.handlers;

import com.zgy.learn.crud.dao.AnimalDao;
import com.zgy.learn.crud.entities.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-22 02:26
 * @Modified by:
 */
@Controller
@RequestMapping(value = "animal")
public class AnimalController {
    @Autowired
    AnimalDao animalDao;

    //    public String addAnimal(@RequestParam("animal") Animal animal) {
    @RequestMapping(value = "add")
    public String addAnimal() {
        return "animaladd";
    }

//    @ModelAttribute
//    public Animal newAnimal() {
//        return new Animal();
//    }

    @RequestMapping("all")
    public String getAllAnimal(ModelMap mp) {
        mp.addAttribute("animals", animalDao.getAll());
        return "animals";
    }
}
