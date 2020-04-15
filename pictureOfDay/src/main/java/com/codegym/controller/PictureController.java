package com.codegym.controller;

import com.codegym.service.IPictureSerVice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PictureController {
private IPictureSerVice pictureSerVice;
  PictureController(IPictureSerVice pictureSerVice){
      this.pictureSerVice=pictureSerVice;
  }
  @GetMapping("/home")
    public ModelAndView all


}
