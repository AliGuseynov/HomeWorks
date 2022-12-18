package Model;

import java.time.LocalDate;
import java.util.List;

public class Receipt {
    private long id;
    private double finalPrice;
    private List<SaleItem> soldItem;
    private LocalDate saleDate;

    public Receipt(long id, double finalPrice, List<SaleItem> soldItem, LocalDate saleDate) {
        this.id = id;
        this.finalPrice = finalPrice;
        this.soldItem = soldItem;
        this.saleDate = saleDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public List<SaleItem> getSoldItem() {
        return soldItem;
    }

    public void setSoldItem(List<SaleItem> soldItem) {
        this.soldItem = soldItem;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "\nReceipt " +
                "id = " + id +
                "\n, finalPrice = " + finalPrice +
                "\n, soldItem = " + soldItem +
                "\n, saleDate = " + saleDate +
                "\n============================================================";
    }
}
