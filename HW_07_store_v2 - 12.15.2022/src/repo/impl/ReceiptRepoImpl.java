package repo.impl;

import model.Receipt;
import model.SaleItem;
import repo.ReceiptRepo;
import repo.SaleItemRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReceiptRepoImpl implements ReceiptRepo {

    private static long globalReceiptId = 0;
    private List<Receipt> receiptList = new ArrayList<>();

    private SaleItemRepo saleItems = new SaleItemRepoImpl();

    @Override
    public void addReceipt(String numbers) {

        List<SaleItem> sales = saleItems.addSaleItem(numbers);

        if (sales.size() > 0) {

            double newPrice = receiptPrice(sales);

            Receipt newReceipt = new Receipt(globalReceiptId, newPrice, sales, LocalDate.now());

            receiptList.add(newReceipt);
            globalReceiptId++;

            System.out.println("New Receipt:");
            System.out.println(newReceipt);
        }
    }

    @Override
    public void refundSaleItem() {

    }

    @Override
    public void refundReceipt() {

    }

    public List<Receipt> findAllReceipt() {
        return receiptList;
    }

    //

    public double receiptPrice(List<SaleItem> saleItems) {
        double finalPrice = 0;

        for (SaleItem item : saleItems) {
            finalPrice += (item.getPrice() * item.getCount());
        }

        return Math.round(finalPrice * 100.0) / 100.0;
    }



    // Getter and Setter
    public static long getGlobalReceiptId() {
        return globalReceiptId;
    }

    public static void setGlobalReceiptId(long globalReceiptId) {
        ReceiptRepoImpl.globalReceiptId = globalReceiptId;
    }

    public List<Receipt> getReceiptList() {
        return receiptList;
    }

    public SaleItemRepo getSaleItems() {
        return saleItems;
    }
}
