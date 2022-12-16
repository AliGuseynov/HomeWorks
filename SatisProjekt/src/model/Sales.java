package model;

import java.time.LocalDate;
import java.util.List;

public class Sales {
    private String salesId;
    private double salesPay;
    private List<SalesItems> salesItems;
    private LocalDate localDate;
    public Sales() {
    }

    public Sales(String salesId, double salesPay, List<SalesItems> salesItems, LocalDate localDate) {
        this.salesId = salesId;
        this.salesPay = salesPay;
        this.salesItems = salesItems;
        this.localDate = localDate;
    }

    public String getSalesId() {
        return salesId;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }

    public double getSalesPay() {
        return salesPay;
    }

    public void setSalesPay(double salesPay) {
        this.salesPay = salesPay;
    }

    public List<SalesItems> getSalesItems() {
        return salesItems;
    }

    public void setSalesItems(List<SalesItems> salesItems) {
        this.salesItems = salesItems;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "salesId=" + salesId +
                ", salesPay=" + salesPay +
                ", salesItems=" + salesItems +
                ", localDate=" + localDate +
                '}';
    }
}