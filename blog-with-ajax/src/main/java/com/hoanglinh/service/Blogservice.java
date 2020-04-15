package com.hoanglinh.service;

import com.hoanglinh.model.Blog;

public interface Blogservice {
    Iterable<Blog> findAll() ;

    Blog findById(Long id);

    Blog save(Blog blog);

    Blog remove(Long id);
}
