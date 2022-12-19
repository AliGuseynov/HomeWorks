package Repositories;

import Models.Item;
import Models.ItemCategorie;

import java.util.List;

public interface ItemRepo {

    public int isExistsInStock (long id, int count);
    public Item findItemById(long id);
    public void printItems();
    public List<Item> findItemsOfCategory(ItemCategorie itemCategory);
    public boolean deleteItem(String inputId);
    public List<Item> findItemsByPriceRange(String dates);
    public List<Item> findItemsByName(String namePart);
    public void addItemToList(Item item);
    public void updateItemToList(Item item);
}
