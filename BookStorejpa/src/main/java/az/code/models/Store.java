package az.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="stores")
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
    private Long id;
    private String storeName;

    @OneToMany(mappedBy = "store",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Branch> branches;
}
