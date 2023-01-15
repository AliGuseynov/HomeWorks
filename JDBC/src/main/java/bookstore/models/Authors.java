package bookstore.models;

import lombok.*;

import javax.persistence.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Authors {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_seq4"
    )
    @SequenceGenerator(
            name = "id_seq4",
            allocationSize = 1
    )
    private Long author_id;

    private String author_name;
}
