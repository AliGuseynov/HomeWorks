package Seeder;

import Model.Item;
import Model.ItemCategory;
import Model.Receipt;
import Model.SaleItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GlobalSeeder {
    private static long globalItemId = 0;
    private static long globalReceiptId = 0;

    // Random Generate
    //-------------------------------------------------------------------------------------------
    public static List<Item> generateRandomItems(int count) {
        List<Item> items = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            Item tempItem = new Item(globalItemId++,
                    "name - " + i,
                    Math.round(Math.random() * i * 100.0) / 100.0,
                    (int) (Math.random() * i),
                    getRandomItemCategory());

            items.add(tempItem);
        }
        return items;
    }
    public static List<Receipt> generateRandomReceipts(int count , List<Item> items) {
        List<Receipt> receipts = new ArrayList<>();

        LocalDate saleDate = LocalDate.now();

        for (int i = 0; i < count; i++) {
            List<SaleItem> tempSalesItem = generateRandomSaleItem(2, items);

            receipts.add(new Receipt(globalReceiptId++, receiptPrice(tempSalesItem), tempSalesItem, saleDate));
        }

        return receipts;
    }
    public static List<SaleItem> generateRandomSaleItem(int count, List<Item> itemsInStock) {

        List<SaleItem> saleItems = new ArrayList<>();

        for (int i = 1; i <= count; i++) {

            int index = (int) (Math.random() * (itemsInStock.size() - 1))  + 1;

            if(checkItemInListExist(index, itemsInStock)) {

                Item randomItem = itemsInStock.get(index);

                SaleItem tempSaleItem = new SaleItem(randomItem,
                        (int) (Math.random() * 5),
                        randomItem.getPrice()
                );

                saleItems.add(tempSaleItem);
            }
        }
        return saleItems;
    }
    public static ItemCategory getRandomItemCategory() {

        int length = ItemCategory.values().length;
        int index = (int) (Math.random() * length);

        return ItemCategory.values()[index];
    }

    // Checkers
    //-------------------------------------------------------------------------------------------
    public static boolean checkItemInListExist(int id, List<Item> itemsInStock) {

        boolean result = false;
        int size = itemsInStock.size();

        for (int i = 0; i < size; i++) {
            if (itemsInStock.get(i).getId() == id)
                return true;
        }

        return result;
    }
    public static double receiptPrice(List<SaleItem> saleItems) {
        double finalPrice = 0;

        for (SaleItem item : saleItems) {
            finalPrice += (item.getPrice() * item.getCount());
        }

        return Math.round(finalPrice * 100.0) / 100.0;
    }


    // Getter and Setters
    //-------------------------------------------------------------------------------------------
    public static long getGlobalItemId() {
        return globalItemId;
    }
    public static long getGlobalReceiptId() {
        return globalReceiptId;
    }
    public static void setGlobalItemId(long globalItemId) {
        GlobalSeeder.globalItemId = globalItemId;
    }
    public static void setGlobalReceiptId(long globalReceiptId) {
        GlobalSeeder.globalReceiptId = globalReceiptId;
    }
}
