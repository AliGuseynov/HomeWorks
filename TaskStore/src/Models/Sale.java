package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Sale {
    private String saleNumber;
    private double cost;
    private List<SalesItem> salesItemList;
    private Date date;

    public Sale(){ //??
        this.cost = 0;
        this.salesItemList = new ArrayList<>();
    };

    public Sale(String saleNumber, Date date){
        this.saleNumber = saleNumber;
        this.date = date;
        this.cost = 0;
        this.salesItemList = new ArrayList<>();
    }

    public void addSalesItem(SalesItem salesItem){
        this.salesItemList.add(salesItem);
        this.cost += salesItem.getProduct().getPrice() * salesItem.getCount();
    }

    public String getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
    }

    public double getCost() {
        return cost;
    }

    public List<SalesItem> getSalesItemList() {
        return salesItemList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return "\nSales number: " + this.getSaleNumber() +"\tCost: " + this.getCost() + "\tDate: " + this.getDate()
                + "\tSales Items: \n" + this.getSalesItemList();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(saleNumber, sale.saleNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleNumber);
    }
}
