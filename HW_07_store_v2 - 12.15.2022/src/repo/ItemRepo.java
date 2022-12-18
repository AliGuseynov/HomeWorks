package repo;

import model.Item;

import java.util.List;

public interface ItemRepo {

    void addNewItem(String[] inputList, String category);
    void editItemDetails(long id, String[] inputList, String category);
    void deleteItem(long id);
    List<Item> findAllItems();
    List<Item> findByCategory(String category);
    List<Item> findByPriceRange(double from, double to);
    List<Item> findByName(String name);
    Item findItemById(long id);
    void renderGenerateRandomItems(int count);
}
