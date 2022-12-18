package Repositories;

import Model.Item;
import Model.ItemCategory;
import Model.Receipt;
import Model.SaleItem;
import Seeder.GlobalSeeder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Repository {
    private List<Item> items;
    private List<Receipt> receipts;

    public Repository() {
        this.items = GlobalSeeder.generateRandomItems(10);
        this.receipts = GlobalSeeder.generateRandomReceipts(0, this.items);
    }

    public List<Item> getItems() {
        return items;
    }
    public List<Receipt> getReceipts() {
        return receipts;
    }

    // Add Functions
    //-------------------------------------------------------------------------------------------
    public void addReceipt(String numbers) {

        List<SaleItem> saleItems = addSaleItem(numbers);

        if (saleItems.size() > 0) {
            long receiptId = GlobalSeeder.getGlobalReceiptId();
            GlobalSeeder.setGlobalReceiptId(++receiptId);
            double newPrice = GlobalSeeder.receiptPrice(saleItems);

            Receipt newReceipt = new Receipt(receiptId, newPrice, saleItems, LocalDate.now());

            receipts.add(newReceipt);
            System.out.println("New Receipt:");
            System.out.println(newReceipt);
        }

    }
    public List<SaleItem> addSaleItem(String numbers) {

        int elementId = 0;
        int count = 0;
        List<SaleItem> saleItems = new ArrayList<>();
        String[] idAndCountList = numbers.split("[^0-9]");

        for (int i = 0; i < idAndCountList.length; i++) {

            if (i % 2 > 0) {
                elementId = Integer.parseInt(idAndCountList[i - 1]); // id = i - 1
                count = Integer.parseInt(idAndCountList[i]); // count = i

                if (isItemExistInStock(elementId, count) > 0) {

                    Item newSalesItem = findItemById(elementId);
                    saleItems.add(new SaleItem(newSalesItem, count, newSalesItem.getPrice()));
                }
            }
        }
        return  saleItems;
    }

    public void addItem(String details, String category) {

        String[] inputList = details.split(" ");

        if (inputList.length == 3) {
            System.out.println("test");
            long id = GlobalSeeder.getGlobalItemId();

            Item newItem = new Item(
                    id,
                    inputList[0],
                    Double.parseDouble(inputList[1]),
                    Integer.parseInt(inputList[2]),
                    ItemCategory.valueOf(category)
            );

            GlobalSeeder.setGlobalItemId(++id);
            items.add(newItem);

            System.out.println("Test2");
            System.out.println(items);

        }

        // public Item(long id, String name, double price, int count, ItemCategory categories)

//        Item newItem =

    }

    // Checker Function
    //-------------------------------------------------------------------------------------------
    public int isItemExistInStock(long id, int count) {

        for (Item item : items) {

            if (item.getId() == id) {

                if (item.getCount() >= count) {

                    item.setCount(item.getCount() - count);
                    return count;
                } else {
                    item.setCount(0);
                    return item.getCount();
                }
            }
        }
        return 0;
    }

    // Refunds Functions
    //-------------------------------------------------------------------------------------------
    public void refundItem(String input) {

        String[] ids = input.split("[^0-9]");
        long saleItemId = Long.parseLong(ids[0]);
        long receiptId = Long.parseLong(ids[1]);

        Item item = findItemById(saleItemId);
        Receipt receipt = findReceiptById(receiptId);

        List<SaleItem> soldItems = receipt.getSoldItem();

        if (receipt == null || item == null) {
            System.out.println("Qəbz/Məhsul sistemdə tapılmadı");
            return;
        }

        System.out.println(receipt);

        for (int i = 0; i < soldItems.size(); i++) {

            if (saleItemId == soldItems.get(i).getItem().getId()) {

                long itemId = soldItems.get(i).getItem().getId();
                findItemById(itemId).setCount(findItemById(itemId).getCount() + soldItems.get(i).getCount());
                soldItems.remove(i);
            }
        }

        receipt.setFinalPrice(GlobalSeeder.receiptPrice(receipt.getSoldItem()));
        System.out.println(receipt);
    }

    public void refundReceipt(String input) {

        long receiptId = Long.parseLong(input);

        Receipt receipt = findReceiptById(receiptId);

        if (receipt == null) {
            System.out.println("Qəbz sistemdə tapılmadı");
            return;
        }

        List<SaleItem> saleItems = receipt.getSoldItem();


        for (SaleItem item : saleItems) {
            Item tmpItem = findItemById(item.getItem().getId());
            tmpItem.setCount(tmpItem.getCount() + item.getCount());
        }

        receipts.remove(receipt);
    }

    // Find Functions
    //-------------------------------------------------------------------------------------------
    public Item findItemById(long id) {

        for (Item item : items) {
            if(item.getId() == id)
                return item;
        }

        return null;
    }
    public Receipt findReceiptById(long id) {

        for (Receipt receipt : receipts) {
            if (receipt.getId() == id)
                return receipt;
        }

        return null;
    }

    public List<Item> findByCategory(String category) {
        List<Item> tempItems = new ArrayList<>();

        for (Item element : items) {

            if (element.getCategories().toString().equals(category) )
                tempItems.add(element);
        }

        return tempItems;
    }


}
