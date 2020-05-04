package com.hoanglinh.repository.Impl;

import com.hoanglinh.model.Drinks;
import com.hoanglinh.repository.DrinkRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
public class DrinkRepositoryImpl implements DrinkRepository{
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Drinks> findAll() {
        TypedQuery<Drinks> query=em.createQuery("select d from Drinks d",Drinks.class);
        List<Drinks> drinksList=query.getResultList();
        return drinksList;
    }

    @Override
    public Drinks findByID(Long id) {
        TypedQuery<Drinks> query=em.createQuery("select d from Drinks d WHERE d.id=:id",Drinks.class);
        query.setParameter("id",id);
        Drinks drinks=query.getSingleResult();
        return drinks;
    }

    @Override
    public void save(Drinks drinks) {
        if (drinks.getId()!=null){
            em.merge(drinks);
        }else {
            em.persist(drinks);
        }
    }

    @Override
    public void remove(Long id) {
      Drinks drinks=findByID(id);
        if (drinks!=null){
            em.remove(id);
        }
    }
}
