package models;

import java.util.List;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sales")

@NamedQuery(name = "all_sales", query = "select a from SaleItem a")

public class Sale {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Sale"
    )
    @SequenceGenerator(
            name = "seq_Sale",
            allocationSize = 1
    )
    private Long sale_id;
    private Double check_sum;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "sale_sale_id", referencedColumnName = "sale_id")
    private List<SaleItem> items;
}
