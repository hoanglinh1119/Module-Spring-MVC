package com.hoanglinh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    @GetMapping("/home")
    public String getIndex() {
        return "en_size_25";
    }

    @PostMapping("/home")
    public String getHome(@RequestParam(required = false) String language, int size, String textaria, Model model) {
        if (language.equals("english") && size == 25) {
            model.addAttribute(textaria);
            return "en_size_25";
        } else if (language.equals("english") && size == 50) {
            model.addAttribute(textaria);
            return "en_size_50";
        } else if (language.equals("english") && size == 100) {
            model.addAttribute(textaria);
            return "en_size_100";
        } else if (language.equals("vietnam") && size == 25) {
            model.addAttribute(textaria);
            return "vn_size_25";
        } else if (language.equals("vietnam") && size == 50) {
            model.addAttribute(textaria);
            return "vn_size_50";
        } else if (language.equals("vietnam") && size == 100) {
            model.addAttribute(textaria);
            return "vn_size_100";
        } else {
            return "en_size_25";
        }
    }
}
