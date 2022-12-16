package model;

public class Product {
    private String productName;
    private double productPrice;
    private Category category;
private double productCount;
private String productId;

    public Product() {
    }

    public Product(String productName, double productPrice, Category category, double productCount, String productId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.category = category;
        this.productCount = productCount;
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getProductCount() {
        return productCount;
    }

    public void setProductCount(double productCount) {
        this.productCount = productCount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", category=" + category +
                ", productCount=" + productCount +
                ", productId='" + productId + '\'' +
                '}';
    }
}
