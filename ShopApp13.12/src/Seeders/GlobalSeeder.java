package Seeders;

import Models.Item;
import Models.ItemCategorie;
import Models.Receipt;
import Models.SaleItem;
import Repositories.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GlobalSeeder {

    private static long globalItemID = 0;

    public static long getGlobalItemID() {
        return globalItemID;
    }

    public static void setGlobalItemID(long globalItemID) {
        GlobalSeeder.globalItemID = globalItemID;
    }

    private static long globalReceiptID = 0;

    public static long getGlobalReceiptID() {
        return globalReceiptID;
    }

    public static void setGlobalReceiptID(long globalReceiptID) {
        GlobalSeeder.globalReceiptID = globalReceiptID;
    }

    private static long globalSaleItemID = 0;

    public static List<Item> generateItems(int count){
        List<Item> items = new ArrayList<>();

        for (int i = 1; i<count+1; i++){

            Item tempItem = new Item("name " + i, Math.round(Math.random() * i * 100.0) / 100.0,
                    (int)Math.round(Math.random() * i)+60,
                    randomCategorie(), globalItemID);

            globalItemID ++;

            items.add(tempItem);


        }



        return items;
    };

    public static List<Receipt> generateReceipts(int count, List<Item> itemsList){

        List<Receipt> receipts = new ArrayList<>();

        LocalDate dateNow = LocalDate.now();

        for (int i = 1; i<count+1;i++){
            int tempPrice = 0;

            List<SaleItem> tempSaleitem = generateSaleItem(5, itemsList);

            Receipt tempReceipt = new Receipt(globalReceiptID, receiptPrice(tempSaleitem),tempSaleitem, dateNow);

            globalReceiptID++;

            receipts.add(tempReceipt);
        }

        for (int i = 0; i<receipts.size(); i++){
//            System.out.println(receipts.get(i));
        }

        return receipts;
    }


    public static List<SaleItem> generateSaleItem(int count, List<Item> items){

        List<SaleItem> saleItems = new ArrayList<>();


        for (int i = 1; i<count; i++){
            int id = (int)(Math.random()*items.size());

            if (!checkItemInListExists(id, items)){


            Item randomItem = items.get(id);


            SaleItem tempSaleItem = new SaleItem( randomItem, (int)(Math.random()*5)+1,
                    Math.round(randomItem.getPrice()*100.0)/100.0);
            saleItems.add(tempSaleItem);

        }}


        return saleItems;
    }


    public static ItemCategorie randomCategorie(){
        return ItemCategorie.values()[(int)(Math.random() * ItemCategorie.values().length)];
    }

    public static double receiptPrice (List<SaleItem> items){
        double finalPrice = 0;

        for (SaleItem itemsloop: items){

            finalPrice = itemsloop.getSalePrice()*itemsloop.getCount() + finalPrice;


        }

//        int tempPrice = (int)(finalPrice);
//        finalPrice = tempPrice/100;


        return Math.round(finalPrice*100.0)/100.0;

    }

    public static boolean checkItemInListExists(int id, List<Item> items){

        int size = items.size();

        for (int i = 0; i<size;i++ ){
            if (items.get(i).getId() == id){
                return true;
            }
        }

        return false;
    }








}
