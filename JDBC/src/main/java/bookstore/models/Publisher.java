package bookstore.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="publishers")
@NamedQueries({
        @NamedQuery(name = "all_publishers", query = "select a from Publisher a")}
)
public class Publisher {


    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_publisher"
    )
    @SequenceGenerator(
            name = "sequence_publisher",
            allocationSize = 1
    )
    private Long publisher_id;

    private String publisher_name;
}
