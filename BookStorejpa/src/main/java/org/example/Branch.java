package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
//    @JoinColumn(name ="store_id",referencedColumnName ="id")
    private Store store;

    @OneToMany(mappedBy = "branch",fetch = FetchType.EAGER)
    private List<BookInstance> bookInstances;
}
