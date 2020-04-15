package com.codegym.repository;

import com.codegym.model.Blog;
import java.util.List;

public interface BlogRepository<T>  {
    List<T> findAll();
    Blog findById (Long id);
    void  save(T model);
    void remove(Long id);
}
