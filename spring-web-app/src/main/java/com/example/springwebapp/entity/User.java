package com.example.springwebapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    long id;

    String username;

    String password;

    Boolean active;

    @ElementCollection(fetch = FetchType.EAGER)//bunu eagersiz qoyanda avtomatik lazy gelir
    // conf dan cagiranda ise elaqe itir map olanu bilmir
    List<Role> role;

}
