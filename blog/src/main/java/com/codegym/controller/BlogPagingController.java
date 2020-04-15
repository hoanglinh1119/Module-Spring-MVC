//package com.codegym.controller;
//
//import com.codegym.model.Blog;
//import com.codegym.service.BlogServicePaging;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Optional;
//@Controller
//
//public class BlogPagingController {
//    @Autowired
//    private BlogServicePaging blogServicePaging;
//    @GetMapping("/Blog")
//    public ModelAndView listCustomers(@RequestParam("s") Optional<String> s, Pageable pageable){
//        Page<Blog> blogs;
//        if(s.isPresent()){
//            blogs = blogServicePaging.findBlogByContent(s.get(), pageable);
//        } else {
//            blogs = blogServicePaging.findAll(pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("blog-paging");
//        modelAndView.addObject("customers", blogs);
//        return modelAndView;
//    }
//}
