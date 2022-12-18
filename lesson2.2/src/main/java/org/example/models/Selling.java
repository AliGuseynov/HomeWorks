package org.example.models;

import java.util.Date;

public class Selling {
    int sellingId;
    SellingItem sellingItem;
    int sellingAmount;
    Date sellingDate;

    public Selling(int sellingId, SellingItem sellingItem, int sellingAmount, Date sellingDate) {
        this.sellingId = sellingId;
        this.sellingItem = sellingItem;
        this.sellingAmount = sellingAmount;
        this.sellingDate = sellingDate;
    }

    public Selling() {
    }

    public int getSellingId() {
        return sellingId;
    }

    public void setSellingId(int sellingId) {
        this.sellingId = sellingId;
    }

    public SellingItem getSellingItem() {
        return sellingItem;
    }

    public void setSellingItem(SellingItem sellingItem) {
        this.sellingItem = sellingItem;
    }

    public int getSellingAmount() {
        return sellingAmount;
    }

    public void setSellingAmount(int sellingAmount) {
        this.sellingAmount = sellingAmount;
    }

    public Date getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
    }

    @Override
    public String toString() {
        return "Selling{" +
                "sellingId=" + sellingId +
                ", sellingItem=" + sellingItem +
                ", sellingAmount=" + sellingAmount +
                ", sellingDate=" + sellingDate +
                '}';
    }
}
