package az.code.DataToExcel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    private int id;
    private String storeName;
//    private String client;
    //    private double storePercent;
//    private double payment;
    private double price;
    private HashMap<String, Double> companiesSold = new HashMap<String, Double>();

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
//                ", client='" + client + '\'' +
                ", price=" + price +
                ", companiesSold=" + companiesSold +
                '}';
    }
}