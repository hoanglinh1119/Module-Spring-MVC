package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
private  ProductService productService=new ProductServiceImpl();

@GetMapping("/index")
    public String index(Model model){
    List products=productService.findAll();
    model.addAttribute("product",products);
    return "/index";
}
@GetMapping("/product/create")
    public String create(Model model){
model.addAttribute("product",new Product());
return "/create";
}
@PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirect){
product.setProductID((int)(Math.random()*10000));
productService.save(product);
redirect.addFlashAttribute("success","Lưu thành công !!!");
return "redirect:/";
}
@GetMapping("/product/{productID}/edit")
    public String edit(@PathVariable int productID, Model model){
model.addAttribute("product",productService.findById(productID));
return "/edit";
}
@PostMapping("/product/update")
    public String update(Product product,RedirectAttributes redirect){
    productService.update(product.getProductID(),product);
    redirect.addFlashAttribute("success","thay đổi thành công");
    return "redirect:/";
}
@GetMapping("/product/{productID}/delete")
    public String delete(@PathVariable int productID, Model model){
    model.addAttribute("product",productService.findById(productID));
    return "/delete";
}
@PostMapping("/product/delete")
    public String delete(Product product,RedirectAttributes redirect){
    productService.remove(product.getProductID());
    redirect.addFlashAttribute("success","đã xóa thành công");
    return "redirect:/";
}
@GetMapping("/product/{productID}/view")
    public String view(@PathVariable int productID,Model model){
    model.addAttribute("product",productService.findById(productID));
    return "/view";
}
}
