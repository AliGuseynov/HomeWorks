package az.code.models;


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

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Book book;
}
