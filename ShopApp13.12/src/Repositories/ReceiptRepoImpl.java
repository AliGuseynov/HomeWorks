package Repositories;

import Models.Receipt;
import Models.SaleItem;

import java.util.ArrayList;
import java.util.List;

public class ReceiptRepoImpl implements ReceiptRepo {

    List<Receipt> receiptList = new ArrayList<>();
    @Override
    public void addReceipt(String idCount) {

    }

    @Override
    public List<SaleItem> getItemsToReceipt(String idCount) {
        return null;
    }

    @Override
    public Receipt refundItem(String input) {
        return null;
    }

    @Override
    public Receipt findReceiptById(long receiptId) {
        return null;
    }

    @Override
    public void printReceipts() {

    }

    @Override
    public boolean deleteReceipt(String inputId) {
        return false;
    }

    @Override
    public List<Receipt> findReceiptsByDate(String dates) {
        return null;
    }

    @Override
    public List<Receipt> findReceiptsBySpecificDate(String dates) {
        return null;
    }

    @Override
    public List<Receipt> findReceiptsByPriceRange(String dates) {
        return null;
    }
}
