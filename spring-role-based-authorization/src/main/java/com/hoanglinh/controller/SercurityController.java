package com.hoanglinh.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Security;

@Controller
public class SercurityController {
    private String getPrincipal(){
        String userName=null;
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            userName=((UserDetails)principal).getUsername();
        }else {
            userName=principal.toString();
        }
        return userName;
    }
    @GetMapping(value = {"/","/home"})
    public String HomePage(Model model){
        model.addAttribute("user",getPrincipal());
        return "home";
    }
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String adminPage(Model model){
        model.addAttribute("user",getPrincipal());
        return "admin";
    }
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String userPage(Model model){
        model.addAttribute("user",getPrincipal());
        return "user";
    }
    @RequestMapping(value = "/dba",method = RequestMethod.GET)
    public String dbaPage(Model model){
        model.addAttribute("user",getPrincipal());
        return "dba";
    }
}
