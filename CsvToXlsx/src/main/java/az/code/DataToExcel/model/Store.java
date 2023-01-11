package az.code.DataToExcel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    private long id;
    private String name;
    private double sale;
    private HashMap<String, Double> companiesSold = new HashMap<String, Double>();
//    private String client;
    //    private double storePercent;
//    private double payment;


    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sale=" + sale +
                ", companiesSold=" + companiesSold +
                '}';
    }
}