package TableTask;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private int id;
    private String clientName;
    private Double price;
    private HashMap<String,Double> map=new HashMap<>();

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", price=" + price +
                ", map=" + map +
                '}';
    }
}
