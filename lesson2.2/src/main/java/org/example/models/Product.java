package org.example.models;

public class Product {
    String productName;
    int productId;
    ProductCategory productCategory;
    int productCount;
    int productAmount;



    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productId=" + productId +
                ", productCategory=" + productCategory +
                ", productCount=" + productCount +
                ", productAmount=" + productAmount +
                '}';
    }

    public int getProductAmount() {
        return productAmount;

    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public Product(String productName, int productId, ProductCategory productCategory, int productCount,int productAmount) {
        this.productName = productName;
        this.productId = productId;
        this.productCategory = productCategory;
        this.productCount = productCount;
        this.productAmount = productAmount;
    }

    public Product() {
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {

        if(productCount>0) this.productCount = productCount;
    }
}
