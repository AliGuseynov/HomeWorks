package org.example;

import java.time.LocalDateTime;

public class Address {
    private int id;
    private String streat;
    private  String city;
    private LocalDateTime creationDate;

    public  Address(int id, String streat, String city, LocalDateTime creationDate) {
        this.id = id;
        this.streat = streat;
        this.city = city;
        this.creationDate = creationDate;
    }

    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreat() {
        return streat;
    }

    public void setStreat(String streat) {
        this.streat = streat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
