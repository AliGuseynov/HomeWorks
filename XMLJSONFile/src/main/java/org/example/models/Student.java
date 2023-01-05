package org.example.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.example.serializeanddeserialize.LocalDateDeserializer;
import org.example.serializeanddeserialize.LocalDateSerializer;

import java.time.LocalDate;
import java.util.List;

@XmlRootElement
public class Student {

    private int id;

    private String name;

    private Address address;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate creationDate;

    private List<Subject> subjects;

    public Student() {
    }

    public Student(int id, String name, Address address, LocalDate creationDate, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.creationDate = creationDate;
        this.subjects = subjects;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @XmlElement
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @XmlElement
    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", creationDate=" + creationDate +
                ", subjects=" + subjects +
                '}';
    }
}
