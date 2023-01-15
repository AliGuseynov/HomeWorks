package bookstore.models;

import lombok.*;

import javax.persistence.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "publishers")

public class Publishers {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_seq6"
    )
    @SequenceGenerator(
            name = "id_seq6",
            allocationSize = 1
    )
    private Long publisher_id;

    private String publisher_name;
}
