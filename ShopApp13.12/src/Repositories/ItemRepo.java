package Repositories;

import Models.Item;
import Models.ItemCategorie;

import java.util.List;

public interface ItemRepo {

    public List<Item> getItems();

    public int isExistsInStock (long id, int count);
    public Item findItemById(long id);
    public void printItems();
    public List<Item> findItemsOfCategory(ItemCategorie itemCategory);
    public boolean deleteItem(Long id);
    public List<Item> findItemsByPriceRange(double minPrice, double maxPrice);
    public List<Item> findItemsByName(String namePart);
    public void addItemToList(Item item);
    public void updateItemToList(Item item);
    public void updateItemCount(int itemId, int count);
    public Item getItemFromId(int id);

    public Item updateItem(Long itemId, String itemName, double itemPrice, int itemCount, ItemCategorie itemCategory);

}
