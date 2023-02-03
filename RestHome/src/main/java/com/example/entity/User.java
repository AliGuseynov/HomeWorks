package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private boolean active;

    @Enumerated
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Roles> roles;


}
