package service;

import Models.Receipt;
import Models.SaleItem;
import Repositories.ReceiptRepo;
import Repositories.ReceiptRepoImpl;
import Seeders.GlobalSeeder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReceiptService {

    private ItemService itemService;
    private ReceiptRepo receiptRepo = new ReceiptRepoImpl();

    public ReceiptService(ItemService itemService) {
        this.itemService = itemService;
    }

    public void addReceipt(String idCount){
        List<SaleItem> saleItems = itemService.getSaleItemList(idCount);


        if (saleItems.size()>0){
            long receiptId = GlobalSeeder.getGlobalReceiptID();
            GlobalSeeder.setGlobalReceiptID(++receiptId);

            double tempFinalPrice = GlobalSeeder.receiptPrice(saleItems);
            Receipt tempReceipt = new Receipt(receiptId, tempFinalPrice,saleItems, LocalDate.now());
            receiptRepo.addReceipt(tempReceipt);

//            System.out.println(tempReceipt.toString());

        }

    }

    public Receipt getReceiptById(Long id){
        List<Receipt> receipts = receiptRepo.getAllReceipts();
        for (Receipt receipt: receipts){
            if (receipt.getId() == id){
                return receipt;
            }
        }
        return null;
    }

    public Receipt refundItemFromReceipt(Long receiptId, int itemId, int count){
        Receipt receiptOld = getReceiptById(receiptId);
        Receipt receipt = new Receipt(receiptOld.getId(), receiptOld.getPrice(), receiptOld.getSoldItems(), receiptOld.getSaleDate());

        itemId = convertItemId(itemId, receipt);

        if (itemId < 0){
            return null;
        }else {
        int tempCount = receipt.getItemCount(itemId, count);
        if (tempCount>0){
            if (tempCount<count){
                count = tempCount;
            }
        }
        receipt.returnItem(itemId, count);
        double tempFinalPrice = GlobalSeeder.receiptPrice(receipt.getSoldItems());
        receipt.setPrice(tempFinalPrice);

            System.out.println("test=============\n" + receipt);
        receiptRepo.updateReceipt(receiptId, receipt);

        System.out.println(itemService.addToItem(receipt.getSoldItems().get(itemId).getItemType(),count));

                return receipt;
    }}

    private int convertItemId(int idIn, Receipt receiptIn){
        List<SaleItem> saleItemList = receiptIn.getSoldItems();
        for (int i = 0; i< saleItemList.size(); i++){
            if (saleItemList.get(i).getItemType().getId() == idIn){
                return i;
            }
        }
        return -1;
    }
    public Receipt deleteReceipt(String receiptIn){
        long id = Long.parseLong(receiptIn.split("[^0-9]")[0]);
        Receipt deleted = receiptRepo.deleteReceipt(id);
        if (deleted == null){
            System.out.println("\nÇek tapılmamışdır...");
        } else {
            System.out.println("\nÇek silinmişdir");
        }

        return deleted;
    }

    public List<Receipt> getAllReceipts() {
        return receiptRepo.getAllReceipts();
    }

    public List<Receipt> findReceiptsByDate(String input) {

        List<Receipt> receiptsOut = new ArrayList<>();
        String [] inputArr = input.split(" ");
        LocalDate startDate = LocalDate.parse(inputArr[0]);
        LocalDate endDate = LocalDate.parse(inputArr[1]);

        receiptsOut = receiptRepo.findReceiptsByDate(startDate, endDate);

        return receiptsOut;
    }

    public List<Receipt> findReceiptsByPriceRange(String input) {

        List<Receipt> receiptsOut = new ArrayList<>();
        String [] inputArr = input.split(" ");
        double minPrice = Double.parseDouble(inputArr[0]);
        double maxPrice = Double.parseDouble(inputArr[1]);

        receiptsOut = receiptRepo.findReceiptsByPriceRange(maxPrice,minPrice);

        return receiptsOut;
    }

    public List<Receipt> findReceiptsBySpecificDate(String input) {

        List<Receipt> receiptsOut = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(input.split(" ")[0]);

        receiptsOut = receiptRepo.findReceiptsBySpecificDate(startDate);
        return receiptsOut;
    }

    public Receipt findReceiptById(long parseLong) {
        Receipt receipt = receiptRepo.findReceiptById(parseLong);
        return receipt;
    }
}
