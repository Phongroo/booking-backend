package com.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "support_status")
public class Support_Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private Integer supportCount;
    @ManyToOne()
    @JoinColumn(name="gdvId")
    private User userSupport;

    public Support_Status(){}

    public Support_Status(LocalDate date, Integer supportCount, User userSupport) {
        this.date = date;
        this.supportCount = supportCount;
        this.userSupport = userSupport;
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

    public Integer getSupportCount() {
        return supportCount;
    }

    public void setSupportCount(Integer supportCount) {
        this.supportCount = supportCount;
    }

    public User getUserSupport() {
        return userSupport;
    }

    public void setUserSupport(User userSupport) {
        this.userSupport = userSupport;
    }
}
