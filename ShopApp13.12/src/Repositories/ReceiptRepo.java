package Repositories;

import Models.Receipt;
import Models.SaleItem;

import java.time.LocalDate;
import java.util.List;

public interface ReceiptRepo {

    public void addReceipt(String idCount);
    public List<SaleItem> getItemsToReceipt(String idCount);
    public Receipt refundItem (String input);
    public Receipt findReceiptById(long receiptId);
    public void printReceipts();
    public Receipt deleteReceipt(LocalDate start, LocalDate end);
    public List<Receipt> findReceiptsByDate(String dates);

    Receipt deleteReceipt(Long inputId);

    List<Receipt> findReceiptsByDate(LocalDate start, LocalDate end);

    public List<Receipt> findReceiptsBySpecificDate(LocalDate dates);
    public List<Receipt> findReceiptsByPriceRange(double max, double min);

    public void addReceipt(Receipt receipt);
    public List<Receipt> getAllReceipts();

    public Receipt updateReceipt(Long receiptId, Receipt receipt);

    public int findReceiptLocation(long receiptId);
}
