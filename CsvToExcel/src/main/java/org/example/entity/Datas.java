package org.example.entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Datas {

    private String id;

    private String store;

    private String client;

    private Double storePercent;

    private Double paymentPercent;

    private Double amount;

    private int count;


    @Override
    public String toString() {
        return "Datas :" + "\n"
                +"Id :" + id + "\n"
                + "Store :" + store + "\n"
                + "Client :" + client + "\n"
                + "Store Percent :" + storePercent + "\n"
                + "Payment :" + paymentPercent + "\n"
                + "amount :" + amount + "\n"
                + "count :" + count + "\n"
                +"-------------------------" + "\n";
    }
}
