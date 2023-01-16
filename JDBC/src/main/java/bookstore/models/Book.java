package bookstore.models;

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
@Table(name="books")
@NamedQueries({
        @NamedQuery(name = "all_books", query = "select a from Book a"),
        @NamedQuery(name = "findBookById", query = "select a from Book a where a.id = ?1")}
)

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
    private Long book_id;

    private String book_name;


    @ManyToMany(mappedBy = "books")
    private List<Author> authors;
}
