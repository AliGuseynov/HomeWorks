package repo;

import model.Receipt;
import model.SaleItem;

import java.util.List;

public interface ReceiptRepo {

    void addReceipt(String numbers);

    void refundSaleItem();

    // 2-3
    void refundReceipt();

    // 2-4
    List<Receipt> findAllReceipt();

    double receiptPrice(List<SaleItem> saleItems);
}
