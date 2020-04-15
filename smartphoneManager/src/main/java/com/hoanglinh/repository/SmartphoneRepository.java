package com.hoanglinh.repository;

import com.hoanglinh.model.Smartphone;
import org.springframework.data.repository.CrudRepository;

public interface SmartphoneRepository extends CrudRepository<Smartphone, Integer> {
}
