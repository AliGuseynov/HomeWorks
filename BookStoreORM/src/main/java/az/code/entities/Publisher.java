package az.code.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_publisher", allocationSize = 1)
    private int publisher_id;

    @Column(name = "publisher_name")
    private String publisherName;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Book book;
}
