package org.example.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import org.example.serializeanddeserialize.LocalDateDeserializer;
import org.example.serializeanddeserialize.LocalDateSerializer;

import java.time.LocalDate;

public class Address {
    private int id;
    private String streat;
    private  String city;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @CsvDate
    private LocalDate creationDate;
    public Address()
    {
        super();
    }
    public  Address(int id, String streat, String city, LocalDate creationDate) {
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", streat='" + streat + '\'' +
                ", city='" + city + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
