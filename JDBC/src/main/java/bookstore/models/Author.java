package bookstore.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="authors")

@NamedQueries({
        @NamedQuery(name = "all_authors", query = "select a from Author a"),
        @NamedQuery(name = "findAuthorById", query = "select a from Author a where a.id = ?1")}
)
public class Author {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_author"
    )
    @SequenceGenerator(
            name = "seq_author",
            allocationSize = 1
    )
    private Long author_id;

    private String author_name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "books_authors",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    private List<Book> books;

}
