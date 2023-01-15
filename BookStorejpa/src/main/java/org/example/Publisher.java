package org.example;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_publisher"
    )
    @SequenceGenerator(
            name = "eq_publisher",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "publisher_name")
    private String name;

    @OneToMany(mappedBy = "publisher",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<BookInstance > bookInstances;
}
