//package com.codegym.repository;
//
//import com.codegym.model.Blog;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.repository.PagingAndSortingRepository;
//
//public interface BlogRepositoryPaging extends PagingAndSortingRepository<Blog,Long> {
//   Page<Blog> findBlogByContent(String content,Pageable pageable);
//   Page<Blog> findAll(Pageable pageable);
//}
