package az.code.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="book_stores")
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
    @Column(name = "store_id")
    private Long id;
    @Column(name = "store_name")
    private String storeName;
    @Column(name = "store_address")
    private String addressName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BRANCH_ID")
    private Branch branches;
//    private Books bo;

}
