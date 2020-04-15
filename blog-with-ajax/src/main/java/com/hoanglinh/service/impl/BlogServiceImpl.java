package com.hoanglinh.service.impl;

import com.hoanglinh.model.Blog;
import com.hoanglinh.repository.BlogRepository;
import com.hoanglinh.service.Blogservice;
import org.springframework.beans.factory.annotation.Autowired;



public class BlogServiceImpl implements Blogservice {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
       blogRepository.save(blog);
        return blog;
    }

    @Override
    public Blog remove(Long id) {
     blogRepository.remove(id);
        return null;
    }
}
