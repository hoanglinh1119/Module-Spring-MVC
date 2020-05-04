package com.hoanglinh.model;

import com.hoanglinh.model.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")

public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @OneToMany(targetEntity = Drinks.class)
    private List<Drinks> drinks;
    @ManyToMany (targetEntity = User.class)
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Drinks> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drinks> drinks) {
        this.drinks = drinks;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
