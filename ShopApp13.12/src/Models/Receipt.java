package Models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Receipt {

    private long id;
    private double finalPrice;

    private List<SaleItem> soldItems;

    private LocalDate saleDate;

    public Receipt(long id, double finalPrice, List<SaleItem> soldItems, LocalDate saleDate) {
        this.id = id;
        this.finalPrice = finalPrice;
        this.soldItems = soldItems;
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "\n-------------RECEIPT--------------\n" +
                "Id = " + id + "\nFinal price = " + finalPrice + "\nItems = " + soldItems + "\n Date: " + saleDate
                + "\n==================================================";
    }

    public double getPrice() {
        return finalPrice;
    }

    public long getId() {
        return id;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public List<SaleItem> getSoldItems() {
        return soldItems;
    }

    public void setPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
