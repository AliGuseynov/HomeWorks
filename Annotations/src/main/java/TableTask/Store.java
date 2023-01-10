package TableTask;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private int id;
    private String storeName;
    private String clientName;
    private Double storePayment;
    private Double payment;
    private Double price;
    private int count;

    @Override
    public String toString() {
        return "Store{" +
                "id='" + id + '\'' +
                ", storeName='" + storeName + '\'' +
                ", clientName='" + clientName + '\'' +
                ", storePayment=" + storePayment +
                ", payment=" + payment +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
