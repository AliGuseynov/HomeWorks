package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_book"
    )
    @SequenceGenerator(
            name = "seq_book",
            allocationSize = 1
    )
   private Long id;
    @Column(name = "book_name")
   private String bookName;


    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<BookInstance> bookInstanceList;


   @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   private Author author;


}
