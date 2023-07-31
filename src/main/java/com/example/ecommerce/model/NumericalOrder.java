package com.example.ecommerce.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "numerical_order")
public class NumericalOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate date;
    private String status;
    private Integer num;
    public NumericalOrder(){}

    public NumericalOrder(LocalDate date, String status, Integer num) {
        this.date = date;
        this.status = status;
        this.num = num;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
