package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;

    @Column
    private String surName;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Task> taskList;
}
