package com.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository<Customer>{
    Page<Customer> findAll(Pageable pageable);
    Customer findById (Long id);
    void  save(Customer model);
    void remove(Long id);
}


