package bookstore.models;

import lombok.*;

import javax.persistence.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stores")
public class Stores {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_seq"
    )
    @SequenceGenerator(
            name = "id_seq",
            allocationSize = 1
    )
    private Long store_id;

    private String store_name;

}
