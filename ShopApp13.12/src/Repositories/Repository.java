package Repositories;

import Models.Item;
import Models.ItemCategorie;
import Models.Receipt;
import Models.SaleItem;
import Seeders.GlobalSeeder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    private List<Item> itemsList = new ArrayList<>();

    private List<Receipt> receiptsList;

    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public Repository() {
        this.itemsList = GlobalSeeder.generateItems(25);
        this.receiptsList = GlobalSeeder.generateReceipts(0, this.itemsList);
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

//    public List<Receipt> getReceiptsList() {
//        return receiptsList;
//    }



    public void addReceipt(String idCount){

        List<SaleItem> saleItems = getItemsToReceipt(idCount);


        if (saleItems.size()>0){
            long receiptId = GlobalSeeder.getGlobalReceiptID();
            GlobalSeeder.setGlobalReceiptID(++receiptId);

            double tempFinalPrice = GlobalSeeder.receiptPrice(saleItems);
            Receipt tempReceipt = new Receipt(receiptId, tempFinalPrice,saleItems, LocalDate.now());
            receiptsList.add(tempReceipt);

            System.out.println(tempReceipt.toString());

        }


    }

    public  List<SaleItem> getItemsToReceipt(String idCount){

        String [] idsList = idCount.split("[^0-9]");
        int elementId = 0;
//        SaleItem tempSaleitem = null;
        List<SaleItem> saleItems = new ArrayList<>();
        int foundCount = 0;
        for (int i = 0; i < idsList.length; i++){

            if ( i % 2 >0) {
                elementId = Integer.parseInt(idsList[i - 1]);

                foundCount = isExistsInStock(Integer.parseInt(idsList[i - 1]), Integer.parseInt(idsList[i]));
//                System.out.println("found count = " + foundCount);
                if (foundCount > 0) {

                    Item tempItem = findItemById(Integer.parseInt(idsList[i - 1]));
                    SaleItem tempSaleitem = new SaleItem(tempItem,Integer.parseInt(idsList[i]), tempItem.getPrice());
                    saleItems.add(tempSaleitem);
                }}}
        return saleItems;
    }

    public int isExistsInStock (long id, int count){

        for (Item itemn: itemsList){

            if (itemn.getId() == id){
                if (count <= itemn.getCount()){
                    itemn.setCount(itemn.getCount() - count);
                    return count;
                } else {
                    itemn.setCount(0);
                    return itemn.getCount();
                }}}
        return 0;
    }

    public Item findItemById(long id){
        for (Item item: itemsList){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public Receipt refundItem (String input){

        String [] inputArr = input.split("[^0-9]");
        long saleItemId = Long.parseLong(inputArr[0]);
        long receiptId = Long.parseLong(inputArr[1]);

        Receipt receipt = findReceiptById(receiptId);
        if (receipt != null){
        List<SaleItem> solditems = receipt.getSoldItems();

        for (int i = 0; i < solditems.size(); i++) {
            if (saleItemId == solditems.get(i).getItemType().getId()) {
                long itemId = solditems.get(i).getItemType().getId();
                findItemById(itemId).setCount(findItemById(itemId).getCount() + solditems.get(i).getCount());
                solditems.remove(i);
            }
        }
        receipt.setPrice(GlobalSeeder.receiptPrice(receipt.getSoldItems()));
        return (receipt);

    }       return null;}

    public Receipt findReceiptById(long receiptId){
        for (Receipt receipt: receiptsList){
            if (receipt.getId() == receiptId){
                System.out.println(receipt);
                return receipt;
            }
        }
        return null;
    }

    public void printReceipts(){
        for (Receipt receipt: receiptsList){
            System.out.println(receipt);
        }
    }
    public void printItems(){
        for (Item item: itemsList){
            System.out.println(item);
        }
    }

    public boolean deleteReceipt(String inputId){
        long id = Long.parseLong(inputId.split("[^0-9]")[0]);
        for (int i = 0; i< receiptsList.size(); i++){
            if (receiptsList.get(i).getId() == id){
                receiptsList.remove(i);
                return true;
            }
        }

        return false;
    }

    public List<Receipt> findReceiptsByDate(String dates){
        List<Receipt> receiptsOut = new ArrayList<>();
        String [] inputArr = dates.split(" ");
        LocalDate startDate = LocalDate.parse(inputArr[0]);
        LocalDate endDate = LocalDate.parse(inputArr[1]);



        for (int i = 0; i< receiptsList.size(); i++){
            LocalDate saleDate = receiptsList.get(i).getSaleDate();

            if (saleDate.isAfter(startDate) && saleDate.isBefore(endDate)){
                receiptsOut.add(receiptsList.get(i));
            }
        }

        return receiptsOut;
    }
    public List<Receipt> findReceiptsBySpecificDate(String dates){
        List<Receipt> receiptsOut = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(dates.split(" ")[0]);



        for (int i = 0; i< receiptsList.size(); i++){
            LocalDate saleDate = receiptsList.get(i).getSaleDate();

            if (saleDate.isEqual(startDate)){
                receiptsOut.add(receiptsList.get(i));
            }
        }

        return receiptsOut;
    }

    public List<Receipt> findReceiptsByPriceRange(String dates){
        List<Receipt> receiptsOut = new ArrayList<>();
        String [] inputArr = dates.split(" ");
        double minPrice = Double.parseDouble(inputArr[0]);
        double maxPrice = Double.parseDouble(inputArr[1]);



        for (int i = 0; i< receiptsList.size(); i++){
            double price = receiptsList.get(i).getPrice();

            if (price > minPrice && price < maxPrice){
                receiptsOut.add(receiptsList.get(i));
            }
        }

        return receiptsOut;
    }

    public List<Item> findItemsOfCategory(ItemCategorie itemCategory){

        List<Item> itemsOut = new ArrayList<>();


        for (int i = 0; i< itemsList.size(); i++){

            if (itemsList.get(i).getCategory() == itemCategory){
                itemsOut.add(itemsList.get(i));
            }
        }

        for (Item item: itemsOut){
            System.out.println(item);
        }

        return itemsOut;
    }

    public boolean deleteItem(String inputId){
        long id = Long.parseLong(inputId.split("[^0-9]")[0]);
        for (int i = 0; i< itemsList.size(); i++){
            if (itemsList.get(i).getId() == id){
                itemsList.remove(i);
                return true;
            }
        }

        return false;
    }

    public List<Item> findItemsByPriceRange(String dates){
        List<Item> itemsListOut = new ArrayList<>();
        String [] inputArr = dates.split(" ");
        double minPrice = Double.parseDouble(inputArr[0]);
        double maxPrice = Double.parseDouble(inputArr[1]);



        for (int i = 0; i< itemsList.size(); i++){
            double price = itemsList.get(i).getPrice();

            if (price > minPrice && price < maxPrice){
                itemsListOut.add(itemsList.get(i));
            }
        }

        return itemsListOut;
    }

    public List<Item> findItemsByName(String namePart){
        List<Item> itemsListOut = new ArrayList<>();
        for (int i = 0; i< itemsList.size(); i++){
            if (itemsList.get(i).getName().contains(namePart)){
                itemsListOut.add(itemsList.get(i));
            }
        }

        return itemsListOut;
    }

    public void addItemToList(Item item){
        itemsList.add(item);
    }
    public void updateItemToList(Item item){
        findItemById(item.getId()).update(item.getName(),item.getPrice(),item.getCount(),item.getCategory());
    }




}
