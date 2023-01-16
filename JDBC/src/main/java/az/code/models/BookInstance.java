package az.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookInstance {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_bookinstance"
    )
    @SequenceGenerator(
            name = "seq_bookinstance",
            allocationSize = 2
    )
    Long id;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Publisher publisher;

    @Column(name="barcode")
    String barcode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    Branch branch;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Book book;
}
