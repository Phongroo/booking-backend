package com.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime startTime =LocalDateTime.now();
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime endTime ;
    private String status;
    private Integer rating;
    private long numericalOrder;
    @OneToOne(cascade={CascadeType.REMOVE,CascadeType.PERSIST})
    private Customers customers;
    @OneToOne(cascade={CascadeType.REMOVE,CascadeType.PERSIST})
    private User userTicket;

    @OneToOne(cascade={CascadeType.REMOVE,CascadeType.PERSIST})
    private Products product;

    public Tickets(){}



    public Tickets(String status, long numericalOrder, Customers customers, User userTicket, Products product) {
        this.status = status;
        this.numericalOrder = numericalOrder;
        this.customers = customers;
        this.userTicket = userTicket;
        this.product = product;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public long getNumericalOrder() {
        return numericalOrder;
    }

    public void setNumericalOrder(long numericalOrder) {
        this.numericalOrder = numericalOrder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public User getUserTicket() {
        return userTicket;
    }

    public void setUserTicket(User userTicket) {
        this.userTicket = userTicket;
    }
}
