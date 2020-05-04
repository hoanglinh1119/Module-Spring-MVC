package com.hoanglinh.service.Impl;

import com.hoanglinh.model.user.User;
import com.hoanglinh.repository.UserRepository;
import com.hoanglinh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByID(Long id) {
       return userRepository.findByID(id);

    }

    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public void remove(Long id) {
   userRepository.remove(id);
    }
}
