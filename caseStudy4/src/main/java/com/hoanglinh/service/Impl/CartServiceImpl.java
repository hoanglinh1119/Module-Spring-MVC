package com.hoanglinh.service.Impl;

import com.hoanglinh.model.Cart;
import com.hoanglinh.repository.CartRepository;
import com.hoanglinh.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findByID(Long id) {
        return cartRepository.findByID(id);
    }

    @Override
    public void save(Cart cart) {
      cartRepository.save(cart);
    }

    @Override
    public void remove(Long id) {
   cartRepository.remove(id);
    }
}
