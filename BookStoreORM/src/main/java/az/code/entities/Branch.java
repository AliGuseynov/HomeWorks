package az.code.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_branch")
    @SequenceGenerator(name = "seq_branch", allocationSize = 1)
    private int branchId;

    @Column(name = "branch_name")
    private String branchName;

    //    @ManyToOne
//    @JoinColumn(name = "store_id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Store store;
}
