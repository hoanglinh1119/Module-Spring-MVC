package com.codegym.repositories.User.Impl;

import com.codegym.model.User.User;
import com.codegym.repositories.User.IUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserRepositoryImpl implements IUserRepository {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query = this.entityManager.createQuery("select s from User s", User.class);
        List<User> users=query.getResultList();
        return users;
    }

    @Override
    public void addUser(User user) {
        this.entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        this.entityManager.merge(user);
    }

    @Override
    public User findByUsername(String username) {
        TypedQuery<User> query=this.entityManager.createQuery("select u from User u where u.username=:username",User.class);
        query.setParameter("username",username);
        List<User> user=query.getResultList();
        return user.get(0);
    }
}
