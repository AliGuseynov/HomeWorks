package az.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name="product")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;

    @Column(name = "price")
    private double price;

    @Column(name = "in_stock_count")
    private int inStockCount;

    @Column(name = "code")
    private Long code;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

}
