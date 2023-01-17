package bookstore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="branches")
@NamedQueries({
        @NamedQuery(name = "all_branches", query = "select a from Branch a"),
        @NamedQuery(name = "findById2", query = "select a from Branch a where a.id = ?1")}
)
public class Branch {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_branch"
    )
    @SequenceGenerator(
            name = "seq_branch",
            allocationSize = 1
    )
    private Long branch_id;

    private String branch_name;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private Store store;
}
