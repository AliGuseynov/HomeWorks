package org.example;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDateTime;
import java.util.List;
@XmlRootElement
public class Student {
    private int id;
    private String name;
    private Address address;
    private LocalDateTime creationDate;
    private List<Subject> subjects;

    public Student() {
    }

    public Student(int id, String name, Address address, LocalDateTime creationDate, List<Subject> subjects) {
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
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    @XmlElement
    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
