package Model;

public class SaleItem {
    private Item item;
    private int count;
    private double price;

    public SaleItem(Item item, int count, double price) {
        this.item = item;
        this.count = count;
        this.price = price;;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "\nId = " + item.getId() +
                " item Name = " + item.getName() +
                " count = " + count +
                " price = " + price;
    }
}
