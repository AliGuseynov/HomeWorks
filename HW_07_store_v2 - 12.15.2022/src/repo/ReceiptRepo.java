package repo;

import model.Receipt;
import model.SaleItem;

import java.time.LocalDate;
import java.util.List;

public interface ReceiptRepo {

    // 2-1
    void addReceipt(List<SaleItem> sales);

    // 2-2
    void refundSaleItem(long receiptId, long itemId);

    // 2-3
    void refundReceipt(Receipt receipt);

    // 2-4
    List<Receipt> findAllReceipt();

    // 2-5
    List<Receipt> findReceiptsByTimeRange(LocalDate from, LocalDate to);

    // 2-6
    List<Receipt> findReceiptsByPriceRange(double from, double to);

    // 2-7
    List<Receipt> findReceiptByDate(LocalDate date);

    // 2-8
    Receipt findReceiptById(long id);

    double receiptPrice(List<SaleItem> saleItems);
}
