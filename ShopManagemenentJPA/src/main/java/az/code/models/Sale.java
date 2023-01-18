package az.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import az.code.models.Item;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "sale")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    @Id
    @Column(name = "sale_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long saleId;

    @Column(name = "amount")
    private double amount;


    @OneToMany(cascade =  CascadeType.ALL)
    @JoinColumn(name = "sold_items")
    private List<Item> items;
}
