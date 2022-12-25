package com.reader.student;

import java.time.LocalDate;

public class Address {
    private int id;

    private String street;

    private String city;

    private LocalDate localDate;

    public Address() {
    }

    public Address(int id, String street, String city, LocalDate localDate) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.localDate = localDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", localDate=" + localDate +
                '}';
    }
}
