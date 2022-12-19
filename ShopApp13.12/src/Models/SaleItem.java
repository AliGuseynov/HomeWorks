package Models;

public class SaleItem {

    private Item itemType;

    private int count;

    private double salePrice;

    public SaleItem(Item itemType, int count, double salePrice) {
        this.itemType = itemType;
        this.count = count;
        this.salePrice = salePrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSalePrice() {
        return salePrice;
    }

    @Override
    public String toString() {
        return  "item id= " + itemType.getId() +
                ", itemType = " + itemType.getName() +
                ", count = " + count +
                ", salePrice = " + salePrice + "\n";
    }

    public Item getItemType() {
        return itemType;
    }

}
