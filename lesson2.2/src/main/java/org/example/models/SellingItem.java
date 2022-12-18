package org.example.models;

import org.example.models.Product;

public class SellingItem {
    Product product;
    int sellingItemId;
    int sellingItemCount;

    public SellingItem() {
    }

    public SellingItem(Product product, int sellingItemId, int sellingItemCount) {
        this.product = product;
        this.sellingItemId = sellingItemId;
        this.sellingItemCount = sellingItemCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getSellingItemId() {
        return sellingItemId;
    }

    public void setSellingItemId(int sellingItemId) {

        this.sellingItemId = sellingItemId;
    }

    public int getSellingItemCount() {
        return sellingItemCount;
    }

    public void setSellingItemCount(int sellingItemCount) {
        this.sellingItemCount = sellingItemCount;
    }

    @Override
    public String toString() {
        return "SellingItem{" +
                "product=" + product +
                ", sellingItemId=" + sellingItemId +
                ", sellingItemCount=" + sellingItemCount +
                '}';
    }
}
