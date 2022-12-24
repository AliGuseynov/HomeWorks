package com.filetask.student;

import javax.xml.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)

public class Student {
    private int id;
    private String name;
    private Address address;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

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
