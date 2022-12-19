package service;

import Models.Item;
import Models.ItemCategorie;
import Models.SaleItem;
import Repositories.ItemRepo;
import Repositories.ItemRepoImpl;
import Seeders.GlobalSeeder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemService {
    private static ReceiptService receiptService;

    private ItemRepo itemRepo = new ItemRepoImpl();

    public List<Item> getItemsList(){
        return itemRepo.getItems();
    }

    public List<SaleItem> getSaleItemList(String elements){
        List<SaleItem> SaleItemList = new ArrayList<>();

        String [] idsList = elements.split("[^0-9]");
        int elementId = 0;

        int foundCount = 0;
        for (int i = 0; i < idsList.length; i++){

            if ( i % 2 >0) {
                elementId = Integer.parseInt(idsList[i - 1]);

                foundCount = isExistsInStock(Integer.parseInt(idsList[i - 1]), Integer.parseInt(idsList[i]));

                if (foundCount > 0) {

                    Item tempItem = itemRepo.getItemFromId(Integer.parseInt(idsList[i - 1]));
                    SaleItem tempSaleitem = new SaleItem(tempItem,Integer.parseInt(idsList[i]), tempItem.getPrice());
                    SaleItemList.add(tempSaleitem);
                }}}

        return SaleItemList;
    }

    public void addItem(String itemName, double itemPrice, int itemCount, ItemCategorie itemCategory){

        long tempId = GlobalSeeder.getGlobalItemID() + 1;
        GlobalSeeder.setGlobalItemID(tempId);
        Item tempItem = new Item(itemName,itemPrice, itemCount, itemCategory, tempId);
        itemRepo.addItemToList(tempItem);
    }

    public int isExistsInStock (long id, int count){

        List<Item> itemsList = itemRepo.getItems();

        for (int i = 0; i<itemsList.size(); i++){
                Item itemn = itemsList.get(i);

            if (itemn.getId() == id){
                if (count <= itemn.getCount()){
                    itemRepo.updateItemCount(i,itemn.getCount() - count);
                    return count;
                } else {
                    itemRepo.updateItemCount(i,0);
                    return itemn.getCount();
                }}}
        return 0;
    }

    public void setReceiptService(ReceiptService receiptService) {
        ItemService.receiptService = receiptService;
    }

    public boolean deleteItem(String inputId){
            long id = Long.parseLong(inputId.split("[^0-9]")[0]);
            return itemRepo.deleteItem(id);
    }

    public Item findItemById(Long id){
        return itemRepo.findItemById(id);
    }

    public Item updateItem(Long itemId, String itemName, double itemPrice, int itemCount, ItemCategorie itemCategory){
        return itemRepo.updateItem(itemId, itemName, itemPrice, itemCount, itemCategory);
    }

    public List<Item> findItemsByCategory(ItemCategorie category){
       return itemRepo.findItemsOfCategory(category);
    }

    public List<Item> fintItemsByPriceRange(String input){

        List<Item> itemsListOut = new ArrayList<>();

        Pattern pattern = Pattern.compile("^[0-9_ ]*$");
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();
        if(matchFound) {

            String [] inputArr = input.split(" ");

            double minPrice = Double.parseDouble(inputArr[0]);
            double maxPrice = Double.parseDouble(inputArr[1]);
            return itemRepo.findItemsByPriceRange(minPrice,maxPrice);
        } else {
            System.out.println("Qiymət aralığı düzgün göstərilməmişdir");
            return itemsListOut;
        }

    }

    public List<Item> findItemByName(String name){
        return itemRepo.findItemsByName(name);
    }

    public Item addToItem (Item item, int count){
        Item itemTemp = findItemByName(item.getName()).get(0);
        itemTemp.setCount(itemTemp.getCount()+count);
        return itemTemp;
    }


}
