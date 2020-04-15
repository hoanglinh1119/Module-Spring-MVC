package com.hoanglinh.service.impl;

import com.hoanglinh.model.Blog;
import com.hoanglinh.repository.BlogRepository;
import com.hoanglinh.service.Blogservice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements Blogservice {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
       blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
     blogRepository.remove(id);
    }
}
