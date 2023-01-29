package com.example.entity;

import lombok.*;
import org.springframework.stereotype.Service;
import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String agencyName;

    @Column
    private String type;
}
