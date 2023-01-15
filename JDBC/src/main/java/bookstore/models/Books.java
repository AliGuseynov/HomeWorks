package bookstore.models;
import lombok.*;
import javax.persistence.*;
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")

public class Books {


    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_seq3"
    )
    @SequenceGenerator(
            name = "id_seq3",
            allocationSize = 1
    )
    private Long book_id;
    private String book_name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "author_id", insertable=false, updatable=false)
    Authors author;
}
