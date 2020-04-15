package mailController;

import model.Information;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class MailController {
    @GetMapping("/email")
    public String email(Model model){


        return "/create";
    }
    @PostMapping("/infromation")
    public String selectBox(@ModelAttribute("email") Information information, BindingResult result, ModelMap model){
        return "/info";
    }
}
