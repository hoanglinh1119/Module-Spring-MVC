package controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class ControllerDict {
    @GetMapping("/display")
    public String view(){
        return "views";
    }
    @GetMapping("/translate")
    public String translate(HttpServletRequest request, Model model){
        HashMap<String,String> dict=new HashMap<>();
        dict.put("red","đỏ");
        dict.put("blue","xanh");
        dict.put("white","trắng");
        dict.put("orange","màu cam");
        dict.put("green","xanh lá");
       String input=request.getParameter("input");
       if (dict.get(input)!=null){
           model.addAttribute("output",dict.get(input));
       }else {
           model.addAttribute("output","Không tìm thấy");
       }
       return "views";
    }
}
