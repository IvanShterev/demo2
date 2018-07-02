package com.example.demo2.entities;

import com.example.demo2.entities.base.ModelEntity;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class Friend implements ModelEntity {
    private int id;
    private String name;
    private String occupation;

    public Friend() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "occupation")
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
