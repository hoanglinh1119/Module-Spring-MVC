package com.hoanglinh.service;

import java.util.List;

public interface GeneralService<T> {
    List<T> findAll();
    T findByID(Long id);
    void save(T t);
    void remove(Long id);
}
