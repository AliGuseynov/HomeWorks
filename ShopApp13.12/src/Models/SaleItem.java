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

    public double getSalePrice() {
        return salePrice;
    }

    @Override
    public String toString() {
        return   "itemType=" + itemType.getName() +
                ", count=" + count +
                ", salePrice=" + salePrice + "\n";
    }

    public Item getItemType() {
        return itemType;
    }
}
