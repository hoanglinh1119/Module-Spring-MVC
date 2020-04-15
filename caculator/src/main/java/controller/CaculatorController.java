package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CaculatorController {
    private static int addition(int value1,int value2){
        return value1+value2;
    }
    private static int subtraction(int value1,int value2){
        return value1-value2;
    }
    private static int multiplication(int value1,int value2){
        return value1*value2;
    }
    private static int division(int value1,int value2){
        return value1/value2;
    }
    @GetMapping ("/index")
    public String getCaculator(){
        return "index";
    }
    @PostMapping("/index")
    public String getResult(@RequestParam int value1, int value2, String select, Model model){
        if (select.equals("addition(+)")){
            int result=addition(value1,value2);
            model.addAttribute("result",result);
            model.addAttribute("select","addition");

        }else if(select.equals("subtraction(-)")){
            int result=subtraction(value1,value2);
            model.addAttribute("result",result);
            model.addAttribute("select","subtraction");


        }else if(select.equals("multiplication(*)")){
            int result=multiplication(value1,value2);
            model.addAttribute("result",result);
            model.addAttribute("select","multiplication");


        }else if (select.equals("division(/)")){
            if (value1!=0){
                int result=division(value1,value2);
                model.addAttribute("result",result);
                model.addAttribute("select","division");

            }
            else{ model.addAttribute("result","khong chia duoc cho 0");
            }
        }
        return "index";
    }
}
