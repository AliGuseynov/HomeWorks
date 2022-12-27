package models;

public class Product {
    private String name;
    private double price;
    private ProductCategory category;
    private int count;
    private String code;

    public Product(){}

    public Product(String name, double price, ProductCategory category, int count, String code){
        this.name = name;
        this.price = price;
        this.category = category;
        setCount(count);
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if(count > 0) this.count = count;
        else System.out.println("Məhsulun sayı 0-dan kiçik ola bilməz");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString(){
        return "\nProduct name: " + this.getName() +"\tPrice: " + this.getPrice() + "\tCategory: "
                + this.getCategory() + "\tCount: " + this.getCount() + "\tCode: " + this.getCode();

        }
}
