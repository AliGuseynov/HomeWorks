package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;

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


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)//?? burda many to one duzgun deyil mentiqen nece yaza bilerdim?
    Publisher publisher;

    @Column(name="barcode")
    String barcode;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Branch branch;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Book book;
}
