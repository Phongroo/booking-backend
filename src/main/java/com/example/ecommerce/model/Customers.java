package com.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private boolean priorty= false;


    public Customers(){}

    public Customers(String fullName, String email, String phoneNumber, boolean priorty) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.priorty = priorty;

    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isPriorty() {
        return priorty;
    }

    public void setPriorty(boolean priorty) {
        this.priorty = priorty;
    }
}
