package az.code.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_store")
    @SequenceGenerator(
            name = "seq_store", allocationSize = 1
    )
    private int storeId;
    @Column(name = "store_name")
    private String storeName;

    //    @OneToMany(mappedBy = "store")
//    @JoinColumn(name = "store_id", referencedColumnName = "branch_id")

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Branch> branches;
}


