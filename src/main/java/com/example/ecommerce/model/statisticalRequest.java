package com.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;

public class statisticalRequest {
//    @JsonFormat(pattern = "yyyy/dd/MM/")
    private LocalDate startTime;
//    @JsonFormat(pattern = "yyyy/dd/MM/")
    private LocalDate endTime;

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }
}