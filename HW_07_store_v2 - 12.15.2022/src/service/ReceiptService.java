package service;

import model.Item;
import model.Receipt;
import model.SaleItem;
import repo.ItemRepo;
import repo.ReceiptRepo;
import repo.impl.ReceiptRepoImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReceiptService {

    ReceiptRepo receiptRepo = new ReceiptRepoImpl();
    ItemService itemService;

    public ReceiptService(ItemService item) {
        this.itemService = item;
    }

    // 2-1
    public void addReceipt(String numbers) {

        List<SaleItem> sales = addSaleItem(numbers);

        receiptRepo.addReceipt(sales);
    }

    // 2-2

    public void refundSaleItem(long receiptId, long itemId) {

//        Item item = itemService.findById(itemId);
//
//        SaleItem saleItem = getSaleItem(receiptId, itemId);
//
//        item.setCount(item.getCount() + saleItem.getCount());

        receiptRepo.refundSaleItem(receiptId, itemId);
    }

    // 2-3
    public void refundReceipt(Long id) {

        Receipt receipt = receiptRepo.findReceiptById(id);

        if (receipt == null) {
            System.out.println("Qəbz sistemdə tapılmadı");
            return;
        }

        List<SaleItem> soldItem = receipt.getSoldItem();

        // return items to stock
        for (SaleItem e : soldItem) {

            Item tmpItem = itemService.findById(e.getItem().getId());

            tmpItem.setCount(tmpItem.getCount() + e.getCount());
        }

        receiptRepo.refundReceipt(receipt);
    }

    // 2-5
    public void findReceiptsByTimeRange(LocalDate from, LocalDate to) {

        List<Receipt> result = receiptRepo.findReceiptsByTimeRange(from, to);

        for (Receipt e : result)
            System.out.println(e);
    }

    // 2-6
    public void findReceiptsByPriceRange(double from, double to) {

        List<Receipt> result = receiptRepo.findReceiptsByPriceRange(from, to);

        for (Receipt e : result)
            System.out.println(e);
    }

    // 2-7
    public void findReceiptByDate(LocalDate date) {

        List<Receipt> result = receiptRepo.findReceiptByDate(date);

        for (Receipt e : result)
            System.out.println(e);
    }

    // 2-8
    public Receipt findReceiptById(long id) {
        return receiptRepo.findReceiptById(id);
    }

    // Sale Items Func
    // -------------------------------------------------------------------
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

                    Item newSalesItem = itemService.findById(elementId);
                    saleItems.add(new SaleItem(newSalesItem, count, newSalesItem.getPrice()));
                }
            }
        }
        return  saleItems;
    }

    public SaleItem getSaleItem(long receiptId, long itemId) {

        Receipt receipt = receiptRepo.findReceiptById(receiptId);

        for (SaleItem e : receipt.getSoldItem())
            if (e.getItem().getId() == itemId)
                return e;

        return null;
    }
    public int isItemExistInStock(long id, int count) {

        List<Item> itemList = itemService.getItems();

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
    // ---------------------------------------------------------------------
    public List<Receipt> getReceipts() {
        return receiptRepo.findAllReceipt();
    }
}
