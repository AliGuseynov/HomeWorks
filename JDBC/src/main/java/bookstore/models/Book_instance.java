package bookstore.models;

import lombok.*;
import javax.persistence.*;
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book_instances")
public class Book_instance {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_seq3"
    )
    @SequenceGenerator(
            name = "id_seq3",
            allocationSize = 1
    )
    private Long bookInstance_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookInstance_id", referencedColumnName = "book_id", insertable=false, updatable=false)
    Books book;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookInstance_id", referencedColumnName = "branch_id", insertable=false, updatable=false)
    Branches branch;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookInstance_id", referencedColumnName = "publisher_id", insertable=false, updatable=false)
    Publishers publisher;
}
