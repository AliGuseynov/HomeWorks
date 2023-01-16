package bookstore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="stores")
@NamedQueries({
        @NamedQuery(name = "all_stores", query = "select a from Store a"),
        @NamedQuery(name = "findById", query = "select a from Store a where a.id = ?1")}
)
public class Store {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_store"
    )
    @SequenceGenerator(
            name = "seq_store",
            allocationSize = 1
    )
    private Long store_id;

    private String store_name;

    @OneToMany(mappedBy = "store",fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    List<Branch> branches = new ArrayList<>();

}
