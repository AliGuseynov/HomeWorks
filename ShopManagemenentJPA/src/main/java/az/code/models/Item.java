package az.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @Column(name = "item_id", nullable = false)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_address"
    )
    @SequenceGenerator(
            name = "seq_address",
            allocationSize = 1
    )
    private Long itemId;

    @Column(name = "item_count")
    private int itemCount;

    @ManyToOne
    @JoinColumn(name = "product_item")
    Product product;


}
