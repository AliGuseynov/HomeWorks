package az.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@Builder
@NoArgsConstructor
@Table(name="salesitems")
public class SalesItems {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_book"
    )
    @SequenceGenerator(
            name = "seq_book",
            allocationSize = 1
    )
    private Long salesItemsId;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Product product;
    private double salescount;
    public SalesItems(Long salesItemsId, Product product, double salescount) {
        this.salesItemsId = salesItemsId;
        this.product = product;
        this.salescount = salescount;
        if (product.getProductCount() - salescount>0) {
            product.setProductCount(product.getProductCount() - salescount);
        }else{
            System.out.println("mehsul qalmayibdi");
        }
    }
    public void setSalescount(double salescount) {
        if(salescount > 0 && salescount <= this.product.getProductCount()) this.salescount = salescount;
        else System.out.println("Say düzgün qeyd olunmayıb");    }


}
