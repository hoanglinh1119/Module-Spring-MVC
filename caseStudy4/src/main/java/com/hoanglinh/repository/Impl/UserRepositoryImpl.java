package com.hoanglinh.repository.Impl;

import com.hoanglinh.model.user.User;
import com.hoanglinh.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<User> findAll() {
        TypedQuery<User> query=em.createQuery("select u from User u",User.class);
        List<User> userList=query.getResultList();
        return userList;
    }

    @Override
    public User findByID(Long id) {
        TypedQuery<User> query=em.createQuery("select u from User u WHERE u.ID=:id",User.class);
        query.setParameter("id",id);
        User user=query.getSingleResult();
        return user;

    }

    @Override
    public void save(User user) {
     if (user.getID()!=null){
     em.merge(user);
     }else {
       em.persist(user);
     }
    }

    @Override
    public void remove(Long id) {
     User user=findByID(id);
      if (user!=null){
        em.remove(id);
      }
    }
}
