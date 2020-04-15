package com.hoanglinh.service;

import com.hoanglinh.model.Smartphone;

public interface SmartphoneSevice {
    Iterable<Smartphone> findAll();
    Smartphone findById(Integer id);
    Smartphone save(Smartphone smartphone);
    Smartphone delete(Integer id);
}
