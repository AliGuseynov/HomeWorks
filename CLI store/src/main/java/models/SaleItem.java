package models;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sale_items")

@NamedQuery(name = "all_items", query = "select a from SaleItem a")
public class SaleItem {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Item"
    )
    @SequenceGenerator(
            name = "seq_Item",
            allocationSize = 1
    )
    private Long item_id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private Product product;
    private Integer count;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private Sale sale;
}
