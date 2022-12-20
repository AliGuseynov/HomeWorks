package repo.impl;

import model.Item;
import model.Receipt;
import model.SaleItem;
import repo.ReceiptRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReceiptRepoImpl implements ReceiptRepo {

    private static long globalReceiptId = 0;
    private List<Receipt> receiptList = new ArrayList<>();

    // 2-1
    @Override
    public void addReceipt(List<SaleItem> sales) {

        if (sales.size() > 0) {

            double newPrice = receiptPrice(sales);

            Receipt newReceipt = new Receipt(globalReceiptId, newPrice, sales, LocalDate.now());

            receiptList.add(newReceipt);
            globalReceiptId++;
        }
    }

    // 2-2
    @Override
    public void refundSaleItem(long receiptId, long itemId) {

        Receipt receipt = findReceiptById(receiptId);

        receipt.getSoldItem().removeIf(e -> e.getItem().getId() == itemId);
    }


    // 2-3
    @Override
    public void refundReceipt(Receipt receipt) {

        receiptList.remove(receipt);
    }

    // 2-4
    public List<Receipt> findAllReceipt() {
        return receiptList;
    }


    // 2-5
    @Override
    public List<Receipt> findReceiptsByTimeRange(LocalDate from, LocalDate to) {

        List<Receipt> result = new ArrayList<>();

        for (Receipt e : receiptList)
            if (e.getSaleDate().isAfter(from.minusDays(1))
                    && e.getSaleDate().isBefore(to.plusDays(1)))
                result.add(e);

        return result;
    }

    // 2-6
    @Override
    public List<Receipt> findReceiptsByPriceRange(double from, double to) {

        List<Receipt> result = new ArrayList<>();

        for (Receipt e : receiptList)
            if (e.getFinalPrice() >= from && e.getFinalPrice() <= to)
                result.add(e);


        return result;
    }

    // 2-7
    @Override
    public List<Receipt> findReceiptByDate(LocalDate date) {

        List<Receipt> result = new ArrayList<>();

        for (Receipt e : receiptList)
            if (e.getSaleDate().isEqual(date))
                result.add(e);

        return result;
    }

    // 2-8
    public Receipt findReceiptById(long id) {

        for (Receipt e : receiptList)
            if (e.getId() == id)
                return e;

        return null;
    }

    //--------------------------------------------------------------------

    public double receiptPrice(List<SaleItem> saleItems) {
        double finalPrice = 0;

        for (SaleItem item : saleItems) {
            finalPrice += (item.getPrice() * item.getCount());
        }

        return Math.round(finalPrice * 100.0) / 100.0;
    }

    // Getter and Setter
    //------------------------------------------------------------------
    public static long getGlobalReceiptId() {
        return globalReceiptId;
    }

    public static void setGlobalReceiptId(long globalReceiptId) {
        ReceiptRepoImpl.globalReceiptId = globalReceiptId;
    }

    public List<Receipt> getReceiptList() {
        return receiptList;
    }

}
