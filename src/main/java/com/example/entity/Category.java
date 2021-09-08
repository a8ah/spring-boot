package com.example.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "name", length = 100)
    private String name;

    @OneToMany
    private Set<Product> poductos;

    public Set<Product> getPoductos() {
        return this.poductos;
    }

    public void setPoductos(Set<Product> poductos) {
        this.poductos = poductos;
    }

    public Category(){};
    
    public Category(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
