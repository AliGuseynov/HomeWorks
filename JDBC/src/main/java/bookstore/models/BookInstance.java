package bookstore.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="book_instances")
@NamedQuery(
        name = "all_bookInstances", query = "select a from BookInstance a"
)
public class BookInstance {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_bookInstance"
    )
    @SequenceGenerator(
            name = "sequence_bookInstance",
            allocationSize = 1
    )
    private Long BInstance_id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private Branch branch;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private Book book;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private Publisher publisher;

    @Override
    public String toString() {
        return "BookInstance{" +
                "BInstance_id=" + BInstance_id +
                ", branch=" + branch.getBranch_name() +
                ", book=" + book.getBook_name() +
                ", publisher=" + publisher.getPublisher_name() +
                '}';
    }
}
