package controller;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller

public class EmployeeController {
    @GetMapping("/showform")
    public String showForm(Model model){
        model.addAttribute("employee",new Employee());
        return "/create";
    }
    @PostMapping("/addEmployee")
    public String submit(@ModelAttribute("employee") Employee employee, BindingResult result,Model model){
        model.addAttribute("name",employee.getName());
        model.addAttribute("id",employee.getId());
        model.addAttribute("contactNumber",employee.getContactNumber());
        return "/info";
    }
}
