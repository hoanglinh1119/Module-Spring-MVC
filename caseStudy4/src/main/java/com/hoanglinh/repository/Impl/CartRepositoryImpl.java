package com.hoanglinh.repository.Impl;

import com.hoanglinh.model.Cart;
import com.hoanglinh.model.Drinks;
import com.hoanglinh.repository.CartRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
public class CartRepositoryImpl implements CartRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Cart> findAll() {
        TypedQuery<Cart> query=em.createQuery("select c from Cart c",Cart.class);
        List<Cart> cartList=query.getResultList();
        return cartList;
    }

    @Override
    public Cart findByID(Long id) {
        TypedQuery<Cart> query=em.createQuery("select c from Cart c WHERE c.id=:id",Cart.class);
        query.setParameter("id",id);
        Cart cartList=query.getSingleResult();
        return cartList;
    }

    @Override
    public void save(Cart cart) {
      if (cart.getId()!=null){
          em.merge(cart);
      }else {
          em.persist(cart);
      }
    }

    @Override
    public void remove(Long id) {
     Cart cart=findByID(id);
     if(cart!=null){
       em.remove(cart);
     }
    }
}
