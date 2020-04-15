//package com.codegym.service;
//
//import com.codegym.model.Blog;
//import com.codegym.repository.BlogRepositoryPaging;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//public class BlogServicePagingImpl implements BlogServicePaging {
//    @Autowired
//    private BlogRepositoryPaging blogRepositoryPaging;
//    @Override
//    public Page<Blog> findBlogByContent(String content, Pageable pageable) {
//        return blogRepositoryPaging.findBlogByContent(content,pageable);
//    }
//
//    @Override
//    public Page<Blog> findAll(Pageable pageable) {
//        return blogRepositoryPaging.findAll(pageable);
//    }
//}
