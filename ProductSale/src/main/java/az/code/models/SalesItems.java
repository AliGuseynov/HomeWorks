package az.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="salesitems")
public class SalesItems {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_salesItems"
    )
    @SequenceGenerator(
            name = "seq_salesItems",
            allocationSize = 1
    )
    private Long salesItemsId;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Product product;
    @Column(name = "salescount")
    private double salescount;



}
