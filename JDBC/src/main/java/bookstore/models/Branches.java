package bookstore.models;
import lombok.*;
import javax.persistence.*;
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "branches")
public class Branches {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_seq2"
    )
    @SequenceGenerator(
            name = "id_seq2",
            allocationSize = 1
    )
    private Long branch_id;
    private String branch_name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id", referencedColumnName = "store_id", insertable=false, updatable=false)
    Stores store;
}
