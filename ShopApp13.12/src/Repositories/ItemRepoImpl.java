package Repositories;

import Models.Item;
import Models.ItemCategorie;
import Seeders.GlobalSeeder;

import java.util.ArrayList;
import java.util.List;

public class ItemRepoImpl implements ItemRepo{

    private List<Item> itemsList = new ArrayList<>();

    public ItemRepoImpl() {
        itemsList = GlobalSeeder.generateItems(25);
    }

    @Override
    public List<Item> getItems() {
        return itemsList;
    }

    @Override
    public int isExistsInStock(long id, int count) {
        return 0;
    }

    @Override
    public Item findItemById(long id) {
        for (Item item: itemsList){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

    @Override
    public void printItems() {

    }

    @Override
    public List<Item> findItemsOfCategory(ItemCategorie itemCategory) {
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

    @Override
    public boolean deleteItem(Long id) {
            for (int i = 0; i< itemsList.size(); i++){
                if (itemsList.get(i).getId() == id){
                    System.out.println("\n Deleted item: \n" + itemsList.get(i));
                    itemsList.remove(i);
                    return true;
                }
            }

            return false;
    }

    @Override
    public List<Item> findItemsByPriceRange(double minPrice, double maxPrice) {

        List<Item> itemsListOut = new ArrayList<>();
        for (int i = 0; i< itemsList.size(); i++){
            double price = itemsList.get(i).getPrice();

            if (price > minPrice && price < maxPrice){
                itemsListOut.add(itemsList.get(i));
            }
        }
        return itemsListOut;
    }

    @Override
    public List<Item> findItemsByName(String namePart) {
        List<Item> itemsListOut = new ArrayList<>();
        for (int i = 0; i< itemsList.size(); i++){
            if (itemsList.get(i).getName().contains(namePart)){
                itemsListOut.add(itemsList.get(i));
            }
        }

        return itemsListOut;
    }

    @Override
    public void addItemToList(Item item) {
        itemsList.add(item);
        System.out.println(item);

    }

    @Override
    public void updateItemToList(Item item) {

    }

    @Override
    public void updateItemCount(int itemId, int count) {
        Item item = itemsList.get(itemId);
        item.setCount(count);
        System.out.println(item);
    }

    @Override
    public Item getItemFromId(int id) {
        return itemsList.get(id);
    }

    @Override
    public Item updateItem(Long itemId, String itemName, double itemPrice, int itemCount, ItemCategorie itemCategory) {


        Item tempItem = new Item(itemName,itemPrice, itemCount, itemCategory, findItemById(itemId).getId());
        System.out.println(tempItem);
        itemsList.add(tempItem);
        return tempItem;
    }

}
