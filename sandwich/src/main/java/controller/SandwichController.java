package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
   @GetMapping ("/sandwich")
    public String getIndex(){
         return "index";
   }
   @PostMapping("/sandwich")
    public String getCondiments(@RequestParam String lettuce, String tomato , String mustand, String sprouts, Model model){
    if (lettuce!=null){
        model.addAttribute("lettuce",lettuce);
    }
    if (tomato!=null){
        model.addAttribute("tomato",tomato);
    }
    if (mustand!=null){
        model.addAttribute("mustand",mustand);
    }
    if (sprouts!=null){
        model.addAttribute("sprouts",sprouts);
    }
    return "showValue";
   }
}
