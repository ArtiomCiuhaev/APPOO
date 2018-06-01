package com.travel.agency.controller;

import org.hibernate.validator.constraints.Range;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotEmpty;

public class OrderDTO {
    @NonNull
    @NotEmpty(message = "Field can't be empty")
    private String client;

    @NonNull
    private int tourID;

    @Range(min = 1L, message = "The field must be a positive number")
    private int count;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public int getTourID() {
        return tourID;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
