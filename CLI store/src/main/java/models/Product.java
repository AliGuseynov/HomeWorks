package models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="products")

@NamedQuery(name = "all_products", query = "select a from Product a")

public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_product"
    )
    @SequenceGenerator(
            name = "seq_product",
            allocationSize = 1
    )
    private Long product_id;
    private String product_name;

    private Double product_price;

    private String product_category;

    private Integer count;

    private String code;

    public void printProduct(){
        System.out.println("Product " + product_id +
                "\nProduct name: " + product_name +
                        "\nProduct code: " + code +
                "\nProduct count: " + count);
    }
}
