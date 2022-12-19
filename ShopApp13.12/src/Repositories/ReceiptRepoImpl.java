package Repositories;

import Models.Receipt;
import Models.SaleItem;

import java.time.LocalDate;
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
        for (Receipt receipt: receiptList){
            if (receipt.getId() == receiptId){
                return receipt;
            }
        }
        return null;
    }

    @Override
    public void printReceipts() {

    }

    @Override
    public Receipt deleteReceipt(LocalDate start, LocalDate end) {
        return null;
    }

    @Override
    public List<Receipt> findReceiptsByDate(String dates) {
        return null;
    }

    @Override
    public Receipt deleteReceipt(Long inputId) {
        for (int i = 0; i< receiptList.size(); i++){
            if (receiptList.get(i).getId()==inputId){
                Receipt receiptOut = receiptList.get(i);
                receiptList.remove(i);
                return receiptOut;
            }
        }
        return null;
    }

    @Override
    public List<Receipt> findReceiptsByDate(LocalDate start, LocalDate end) {
        List<Receipt> receiptsOut = new ArrayList<>();

        for (int i = 0; i< receiptList.size(); i++){
            LocalDate saleDate = receiptList.get(i).getSaleDate();

            if (saleDate.isAfter(start) && saleDate.isBefore(end)){
                receiptsOut.add(receiptList.get(i));
            }
        }
        return receiptsOut;
    }

    @Override
    public List<Receipt> findReceiptsBySpecificDate(LocalDate dates) {
        List<Receipt> receiptsOut = new ArrayList<>();
        for (int i = 0; i< receiptList.size(); i++){
            LocalDate saleDate = receiptList.get(i).getSaleDate();

            if (saleDate.isEqual(dates)){
                receiptsOut.add(receiptList.get(i));
            }
        }

        return receiptsOut;
    }

    @Override
    public List<Receipt> findReceiptsByPriceRange(double max, double min) {

        List<Receipt> receiptsOut = new ArrayList<>();
        for (int i = 0; i< receiptList.size(); i++){
            double price = receiptList.get(i).getPrice();

            if (price > min && price < max){
                receiptsOut.add(receiptList.get(i));
            }
        }
        return receiptsOut;
    }

    @Override
    public void addReceipt(Receipt receipt) {
        receiptList.add(receipt);
        System.out.println(receipt);
    }

    @Override
    public List<Receipt> getAllReceipts() {
        return receiptList;
    }

    @Override
    public Receipt updateReceipt(Long receiptId, Receipt receiptIn) {
        Receipt receiptTemp = findReceiptById(receiptId);
        int receiptLocation = findReceiptLocation(receiptId);
        receiptList.get(receiptLocation).setPrice(receiptIn.getPrice());
        receiptList.get(receiptLocation).setSoldItems(receiptIn.getSoldItems());
        return receiptTemp;
    }

    @Override
    public int findReceiptLocation(long receiptId) {
        for (int i = 0; i< receiptList.size(); i++){
            if (receiptList.get(i).getId() == receiptId){
                return i;
            }
        }
        return -1;
    }

}
