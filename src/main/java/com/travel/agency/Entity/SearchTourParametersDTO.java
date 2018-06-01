package com.travel.agency.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class SearchTourParametersDTO {
    private String title;

    private String address;

    private Integer starLow;

    private Integer starUp;

    private String transport;
    
    private boolean onlyHot;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateLow;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateUp;

    private int duration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStarLow() {
        return starLow;
    }

    public void setStarLow(Integer starLow) {
        this.starLow = starLow;
    }

    public Integer getStarUp() {
        return starUp;
    }

    public void setStarUp(Integer starUp) {
        this.starUp = starUp;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public boolean isOnlyHot() {
        return onlyHot;
    }

    public void setOnlyHot(boolean onlyHot) {
        this.onlyHot = onlyHot;
    }

    public LocalDate getDateLow() {
        return dateLow;
    }

    public void setDateLow(LocalDate dateLow) {
        this.dateLow = dateLow;
    }

    public LocalDate getDateUp() {
        return dateUp;
    }

    public void setDateUp(LocalDate dateUp) {
        this.dateUp = dateUp;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
