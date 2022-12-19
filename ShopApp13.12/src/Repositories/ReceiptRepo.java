package Repositories;

import Models.Receipt;
import Models.SaleItem;

import java.util.List;

public interface ReceiptRepo {

    public void addReceipt(String idCount);
    public List<SaleItem> getItemsToReceipt(String idCount);
    public Receipt refundItem (String input);
    public Receipt findReceiptById(long receiptId);
    public void printReceipts();
    public boolean deleteReceipt(String inputId);
    public List<Receipt> findReceiptsByDate(String dates);
    public List<Receipt> findReceiptsBySpecificDate(String dates);
    public List<Receipt> findReceiptsByPriceRange(String dates);
}
