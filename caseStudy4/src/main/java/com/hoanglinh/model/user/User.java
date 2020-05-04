package com.hoanglinh.model.user;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String userName;
    private String password;
    private String email;
    @ManyToOne Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Long ID, String userName, String password, Role role) {
        this.ID = ID;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
    public User(String userName, String password,Role role){
        this.password=password;
        this.userName=userName;
        this.role=role;
    }
}
