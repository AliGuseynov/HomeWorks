package com.reader.student;

import java.time.LocalDate;
import java.util.List;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private Address address;
    private LocalDate creationDate;



    public Student() {
    }

    public Student(int id, String name, Address address, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.creationDate = creationDate;

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



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", creationDate=" + creationDate +
                '}';
    }


    @Override
    public int compareTo(Student student) {
        return this.id-student.id;
    }
}
