package com.hoanglinh.service.impl;

import com.hoanglinh.model.Smartphone;
import com.hoanglinh.repository.SmartphoneRepository;
import com.hoanglinh.service.SmartphoneSevice;
import org.springframework.beans.factory.annotation.Autowired;

public class SmartphoneServiceImpl implements SmartphoneSevice {
    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        return smartphoneRepository.findOne(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    @Override
    public Smartphone delete(Integer id) {
        Smartphone smartphone=findById(id);
        smartphoneRepository.delete(id);
        return smartphone;
    }
}
