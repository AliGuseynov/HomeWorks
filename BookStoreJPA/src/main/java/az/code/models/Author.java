package az.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
@NamedQuery(name = "all", query = "select a from Author a"),
@NamedQuery(name = "findById", query = "select a from Author a where a.id = ?1")}
)
public class Author {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_author"
    )
    @SequenceGenerator(
            name = "seq_author",
            allocationSize = 3
    )
    private Long id;
    @Column(name = "author_name")
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "books_authors",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    private List<Book> books;

}
