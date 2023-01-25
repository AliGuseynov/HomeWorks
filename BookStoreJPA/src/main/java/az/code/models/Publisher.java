package az.code.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
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
