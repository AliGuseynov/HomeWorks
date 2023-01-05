package az.code.shopManagement.model;

public class Product {
    private int id;
    private String productName;
    private double price;
    private int inStockCount;
    private int outOfStockCount;
    Category category;

    public Product(){

    }

    public Product(int id, String productName, double price, int inStockCount, int outOfStockCount, Category category) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.inStockCount = inStockCount;
        this.outOfStockCount = outOfStockCount;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInStockCount() {
        return inStockCount;
    }

    public void setInStockCount(int inStockCount) {
        this.inStockCount = inStockCount;
    }

    public int getOutOfStockCount() {
        return outOfStockCount;
    }

    public void setOutOfStockCount(int outOfStockCount) {
        this.outOfStockCount = outOfStockCount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String toString() {
        return "\nProduct id :" + id + " | " +
                "Product name :" + productName + " | " +
                "Product price :" + price + " | " +
                "Product count (In Stock): :" + inStockCount + " | " +
                "Product count (Out of Stock):" + outOfStockCount + " | " +
                "Product category :" + category ;
    }
}
