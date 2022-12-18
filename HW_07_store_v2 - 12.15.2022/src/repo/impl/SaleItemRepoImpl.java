package repo.impl;

import model.Item;
import model.SaleItem;
import repo.ItemRepo;
import repo.SaleItemRepo;

import java.util.ArrayList;
import java.util.List;

public class SaleItemRepoImpl implements SaleItemRepo {

    // !!
    ItemRepo itemRepo = new ItemRepoImpl();

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

                    Item newSalesItem = itemRepo.findItemById(elementId);
                    saleItems.add(new SaleItem(newSalesItem, count, newSalesItem.getPrice()));
                }
            }
        }
        return  saleItems;
    }

    public int isItemExistInStock(long id, int count) {

        // !!
        List<Item> itemList = itemRepo.findAllItems();

        for (Item item : itemList) {

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


    // Getter


    public ItemRepo getItemRepo() {
        return itemRepo;
    }
}
