package com.example.demo2.entities;

import com.example.demo2.entities.base.ModelEntity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements ModelEntity {
    private int id;
    private String username;
    private String password;

    public User() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "username", length = 25, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
