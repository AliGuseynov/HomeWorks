package az.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;


    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Publisher> publishers;

}
