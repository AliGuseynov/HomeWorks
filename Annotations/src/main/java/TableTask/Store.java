package TableTask;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Store {
    private String id;
    private String storeName;
    private String clientName;
    private String storePayment;
    private String payment;
    private String price;
    private String count;

    public Store(String id, String storeName, String clientName, String storePayment, String payment, String price, String count) {
        this.id = id;
        this.storeName = storeName;
        this.clientName = clientName;
        this.storePayment = storePayment;
        this.payment = payment;
        this.price = price;
        this.count = count;
    }

    public String getTotalPayment(){
        double pay=Double.parseDouble(storePayment)+Double.parseDouble(payment);
        return String.valueOf(pay);
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", clientName='" + clientName + '\'' +
                ", Payment=" +getTotalPayment()+
                ", price=" + price +
                '}';
    }
}
