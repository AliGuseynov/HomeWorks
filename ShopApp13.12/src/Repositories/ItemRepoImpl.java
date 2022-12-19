package Repositories;

import Models.Item;
import Models.ItemCategorie;

import java.util.ArrayList;
import java.util.List;

public class ItemRepoImpl implements ItemRepo{

    List<Item> itemsList = new ArrayList<>();
    @Override
    public int isExistsInStock(long id, int count) {
        return 0;
    }

    @Override
    public Item findItemById(long id) {
        return null;
    }

    @Override
    public void printItems() {

    }

    @Override
    public List<Item> findItemsOfCategory(ItemCategorie itemCategory) {
        return null;
    }

    @Override
    public boolean deleteItem(String inputId) {
        return false;
    }

    @Override
    public List<Item> findItemsByPriceRange(String dates) {
        return null;
    }

    @Override
    public List<Item> findItemsByName(String namePart) {
        return null;
    }

    @Override
    public void addItemToList(Item item) {

    }

    @Override
    public void updateItemToList(Item item) {

    }
}
