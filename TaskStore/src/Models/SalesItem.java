package models;

public class SalesItem {
    private String number;
    private Product product;
    private int count;

    public SalesItem(String number, Product product, int count){
        this.number = number;
        this.product = product;
        setCount(count);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if(count > 0 && count <= this.product.getCount()) this.count = count;
        else System.out.println("Say düzgün qeyd olunmayıb");
    }

    @Override
    public String toString(){
        return "\nSales Item Number: " + this.getNumber() + "\tCount: " + this.getCount() +"\tProduct \n" + this.getProduct();

    }
}
