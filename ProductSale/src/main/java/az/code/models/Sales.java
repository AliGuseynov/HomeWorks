package az.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sales")
@Entity
public class Sales {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_book"
    )
    @SequenceGenerator(
            name = "seq_book",
            allocationSize = 1
    )
    private Long salesId;
    @Column(name = "salespay")
    private double salesPay;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<SalesItems> salesItems;
    @Column(name = "localdate")
    private LocalDate localDate;

}