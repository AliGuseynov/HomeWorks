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
            generator = "seq_product"
    )
    @SequenceGenerator(
            name = "seq_product",
            allocationSize = 1
    )
    private Long sale_id;
    private Double check_sum;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private List<SaleItem> items;
}
