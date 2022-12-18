package Model;

public class Item {
    private long id;
    private String name;
    private double price;
    private int count;
    private ItemCategory categories;

    public Item(long id, String name, double price, int count, ItemCategory categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.categories = categories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ItemCategory getCategories() {
        return categories;
    }

    public void setCategories(ItemCategory categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "\nItem{" +
                "id=" + id +
                ", name = '" + name + '\'' +
                ", price = " + price +
                ", count = " + count +
                ", categories = " + categories +
                '}' + "\n";
    }
}
