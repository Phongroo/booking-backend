package com.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String desccription;
    private boolean supportGdv;



    public Products(){}

    public Products(String name, String desccription, boolean supportGdv) {
        this.name = name;
        this.desccription = desccription;
        this.supportGdv = supportGdv;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesccription() {
        return desccription;
    }

    public void setDesccription(String desccription) {
        this.desccription = desccription;
    }

    public boolean isSupportGdv() {
        return supportGdv;
    }

    public void setSupportGdv(boolean supportGdv) {
        this.supportGdv = supportGdv;
    }
}
