package com.hoanglinh.repository;

import java.util.List;

public interface GeneralRepository<T> {
     List<T> findAll();
     T findByID(Long id);
     void save(T t);
     void remove(Long id);
}
