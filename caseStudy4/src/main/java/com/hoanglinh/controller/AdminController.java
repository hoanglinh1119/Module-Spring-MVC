package com.hoanglinh.controller;

import com.hoanglinh.model.Drinks;
import com.hoanglinh.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@PropertySource("classpath:global_config_app.properties")
public class AdminController {
    @Autowired
    Environment env;
    @Autowired
    private DrinkService drinkService;
@GetMapping("/drinks")
    public ModelAndView showDrink(){
    List<Drinks> drinksList=drinkService.findAll();
    ModelAndView modelAndView=new ModelAndView("user/index");
      modelAndView.addObject("drinks",drinksList);
      return modelAndView;
}
}
