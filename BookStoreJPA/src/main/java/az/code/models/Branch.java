package az.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="branches")
public class Branch{

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_branch"
    )
    @SequenceGenerator(
            name = "seq_branch",
            allocationSize = 1
    )
    private Long id;

    private String branchName;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Store store;
}
