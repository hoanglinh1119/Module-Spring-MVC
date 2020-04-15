package com.hoanglinh.controller;

import com.hoanglinh.model.Blog;
import com.hoanglinh.service.Blogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class BlogController {
      @Autowired
    private Blogservice blogservice;
     @RequestMapping(value = "/create",method = RequestMethod.GET)
    public ModelAndView createBlog(){
 ModelAndView mav=new ModelAndView("blog-view/new-blog");
 mav.addObject("blog",new Blog());
   return mav;
     }
    @RequestMapping(value = "/createnewPhone", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Blog createBlog(@RequestBody Blog blog) {
        return blogservice.save(blog);
    }
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Blog> blogs() {
        return blogservice.findAll();
    }
    @GetMapping("")
    public ModelAndView allBlogPage() {
        ModelAndView modelAndView = new ModelAndView("blog-view/all-blog");

        modelAndView.addObject("blog", blogs());
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Blog deleteSmartphone(@PathVariable Long id) {
        return blogservice.remove(id);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editBlogPage(@PathVariable Long id){
        Blog blog = blogservice.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("blog-view/edit-blog");
            modelAndView.addObject("blogs",blog);
            return modelAndView;
        }
        return null;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Blog editBlog(@PathVariable Long id, @RequestBody Blog blog){
        blog.setId(id);
        return blogservice.save(blog);
    }
}
