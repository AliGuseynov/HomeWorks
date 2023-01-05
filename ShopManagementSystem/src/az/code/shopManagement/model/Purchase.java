package az.code.shopManagement.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Purchase {
    private int id;
    private double totalCost;
    private LocalDate purchaseDate;
    List<PurchasedGood> purchasedGoods;

    public Purchase(){

    }

    public Purchase(int id, double totalCost, LocalDate purchaseDate,   List<PurchasedGood> purchasedGoods) {
        this.id = id;
        this.totalCost = totalCost;
        this.purchaseDate = purchaseDate;
        this.purchasedGoods = purchasedGoods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public List<PurchasedGood> getPurchasedGoods() {
        return purchasedGoods;
    }

    public void setPurchasedGoods(List<PurchasedGood> purchasedGoods) {
        this.purchasedGoods = purchasedGoods;
    }
}
