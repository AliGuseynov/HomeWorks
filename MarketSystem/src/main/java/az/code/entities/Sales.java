package az.code.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sale_id;

    @Column(name = "sale_amount")
    private double saleAmount;

    @OneToMany(mappedBy = "sales", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Item> itemList;
}
