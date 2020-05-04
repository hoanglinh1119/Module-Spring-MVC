package com.hoanglinh.service.Impl;

import com.hoanglinh.model.Drinks;
import com.hoanglinh.repository.DrinkRepository;
import com.hoanglinh.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DrinkServiceImpl implements DrinkService {
    @Autowired
    private DrinkRepository drinkRepository;
    @Override
    public List<Drinks> findAll() {
        return drinkRepository.findAll();
    }

    @Override
    public Drinks findByID(Long id) {
        return drinkRepository.findByID(id);
    }

    @Override
    public void save(Drinks drinks) {
    drinkRepository.save(drinks);
    }

    @Override
    public void remove(Long id) {
  drinkRepository.remove(id);
    }
}
