package com.codegym.controller.User;

import com.codegym.model.Product.Product;
import com.codegym.model.User.User;
import com.codegym.service.Product.IProductService;
import com.codegym.service.User.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.codegym.controller.Product.ProductAjax.productListAddToCart;

@Controller
public class SercurityController {

    @Autowired
    IProductService productService;

    @Autowired
    IUserService userService;

    static int size = 3;
    static int page = 0;

    Page<Product> getAllProduct() {
        return this.productService.getAllProduct("", size, page);
    }

    private String getPrincipal() {
        String role = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            role = String.valueOf(((UserDetails) principal).getAuthorities());
        } else {
            role = null;
        }
        return role;
    }

    @GetMapping(value = {"/", "/home", "/user", "/Access_Denied"})
    public String Homepage(Model model) {
//        List<Product> products = this.productService.getAllProduct();
        int sizeNewProduct = 3;
        Page<Product> newProducts = this.productService.getAllProduct("", sizeNewProduct, 3);
        Page<Product> products = getAllProduct();
        String role=getPrincipal();
        model.addAttribute("user", getPrincipal());
        model.addAttribute("products", products);
        model.addAttribute("newProducts", newProducts);
        model.addAttribute("amountCart", productListAddToCart.size());

        if (role==null||role.equals("[ROLE_USER]")){
                return "index";
        }
        else {
            return "admin";
        }
    }

    @GetMapping(value = {"/admin", "/dba"})
    public String showAdminPage(Model model) {
        int sizeNewProduct = 3;
        Page<Product> newProducts = this.productService.getAllProduct("", sizeNewProduct, 3);
        Page<Product> products = getAllProduct();
        model.addAttribute("user", getPrincipal());
        model.addAttribute("products", products);
        model.addAttribute("newProducts", newProducts);
        model.addAttribute("amountCart", productListAddToCart.size());

        return "admin";
    }

    @GetMapping("/login")
    public String showForm(String username, String password, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("password", password);
//        model.addAttribute("message", "");
        if (getPrincipal() == null) {
            model.addAttribute("amountCart", productListAddToCart.size());
            return "login";
        } else {
//            model.addAttribute("user",getPrincipal());
            return "redirect:/";
        }
    }

    @RequestMapping("/signout")
    public String doLogout() {
        return "redirect:/";
    }

    @GetMapping("/change-infor")
    public String manageAccount(Model model) {

        model.addAttribute("user", getPrincipal());
        model.addAttribute("amountCart", productListAddToCart.size());

        model.addAttribute("username", getUserPrincipal().getUsername());
        model.addAttribute("email", getUserPrincipal().getEmail());
        return "change-info";
    }

    @GetMapping("/change-password")
    public String changePassword(Model model) {
        model.addAttribute("user", getPrincipal());
        model.addAttribute("amountCart", productListAddToCart.size());
        return "change-pass";
    }

    @PostMapping("/change-infor")
    public String updateInfo(@RequestParam("username") String username,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
                             Model model) {
        User user = getUserPrincipal();
        if (!password.equals(user.getPassword())) {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("message", "Incorrect password!");
        } else {
            user.setUsername(username);
            user.setEmail(email);
            this.userService.updateUser(user);
            model.addAttribute("message", "Update success!");
        }
        model.addAttribute("user", getPrincipal());
        model.addAttribute("amountCart", productListAddToCart.size());
        return "change-info";

    }

    @PostMapping("/change-password")
//    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public String updatePassword(@RequestParam("password") String password,
                                 @RequestParam("passwordsubmit") String passwordsubmit,
                                 Model model) {
        User user = getUserPrincipal();
        if (!passwordsubmit.equals(user.getPassword())) {
            model.addAttribute("message", "Incorrect password!");
        } else {
            user.setPassword(password);
            this.userService.updateUser(user);
            model.addAttribute("message", "Update success!");
        }
        model.addAttribute("user", getPrincipal());
        model.addAttribute("amountCart", productListAddToCart.size());
        return "change-pass";
    }


    @RequestMapping("/admin/user-manage")
    public String showFormManageUser(Model model){
        model.addAttribute("user", getPrincipal());
        model.addAttribute("amountCart", productListAddToCart.size());
        List<User> users=this.userService.getAllUser();
        model.addAttribute("users",users);
        return "user-manage";
    }


    public User getUserPrincipal() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(((UserDetails) principal).getUsername());
        User user = this.userService.findUserByName(((UserDetails) principal).getUsername());
        return user;
    }
}