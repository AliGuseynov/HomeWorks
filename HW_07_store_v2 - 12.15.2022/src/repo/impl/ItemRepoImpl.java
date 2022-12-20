package repo.impl;

import model.Item;
import model.ItemCategory;
import repo.ItemRepo;

import java.util.ArrayList;
import java.util.List;

public class ItemRepoImpl implements ItemRepo {

    private static long globalItemId = 0;
    private List<Item> itemList = new ArrayList<>();


    @Override
    public void addNewItem(String[] inputList, String category) {

        long id = ItemRepoImpl.getGlobalItemId();

        itemList.add(new Item(
                id,
                inputList[0],
                Double.parseDouble(inputList[1]),
                Integer.parseInt(inputList[2]),
                ItemCategory.valueOf(category)
        ));

        ItemRepoImpl.setGlobalItemId(++id);
    }

    @Override
    public void editItemDetails(long id, String[] inputList, String category) {

        for (Item e : itemList) {

            if(e.getId() == id) {

                e.setName(inputList[0]);
                e.setPrice(Double.parseDouble(inputList[1]));
                e.setCount(Integer.parseInt(inputList[2]));
                e.setCategory(ItemCategory.valueOf(category));
            }
        }
    }

    @Override
    public void deleteItem(long id) {

        for (Item e : itemList) {
            if (e.getId() == id)
                itemList.remove(e);
        }
    }

    @Override
    public List<Item> findAllItems() {
        return itemList;
    }

    @Override
    public List<Item> findByCategory(String category) {

        List<Item> result = new ArrayList<>();

        for (Item e : itemList)
            if (e.getCategory() == ItemCategory.valueOf(category))
                result.add(e);

        return result;
    }

    @Override
    public List<Item> findByPriceRange(double from, double to) {

        List<Item> result = new ArrayList<>();

        for (Item e : itemList)
            if (e.getPrice() >= from && e.getPrice() <= to)
                result.add(e);

        return result;
    }

    @Override
    public List<Item> findByName(String name) {

        List<Item> result = new ArrayList<>();

        for (Item e : itemList)
            if (e.getName().contains(name))
                result.add(e);

        return result;
    }

    @Override
    public Item findById(long id) {

        for (Item e : itemList)
            if (e.getId() == id)
                return e;

        return null;
    }

    @Override
    public void renderGenerateRandomItems(int count) {

        List<Item> items = new ArrayList<>();

        for (int i = 1; i <= count; i++) {

            int length = ItemCategory.values().length;
            int index = (int) (Math.random() * length);

            Item tempItem = new Item(
                    globalItemId++,
                    "name - " + i,
                    Math.round(Math.random() * i * 100.0) / 100.0,
                    (int) (Math.random() * i),
                    ItemCategory.values()[index]
            );

            items.add(tempItem);
        }

        itemList = items;
    }

    public static ItemCategory getRandomItemCategory() {

        int length = ItemCategory.values().length;
        int index = (int) (Math.random() * length);

        return ItemCategory.values()[index];
    }

    // Getter and Setter
    public static long getGlobalItemId() {
        return globalItemId;
    }

    public static void setGlobalItemId(long globalItemId) {
        ItemRepoImpl.globalItemId = globalItemId;
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
