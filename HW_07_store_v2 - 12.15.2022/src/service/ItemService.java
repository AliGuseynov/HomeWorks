package service;

import model.Item;
import repo.ItemRepo;
import repo.impl.ItemRepoImpl;

import java.util.List;

public class ItemService {
    ItemRepo itemRepo = new ItemRepoImpl();

    public void addItem(String input, String category) {

        String[] inputList = input.split(" ");

        if (inputList.length == 3) {
            itemRepo.addNewItem(inputList, category);
        } else {
            System.out.println("Wrong Input");
        }
    }

    public void editItem(long id, String input, String category) {

        String[] inputList = input.split(" ");

        if (inputList.length == 3) {
            itemRepo.editItemDetails(id, inputList, category);
        } else {
            System.out.println("Wrong Input");
        }
    }

    public void deleteItem(long id) {
        itemRepo.deleteItem(id);
    }

    public List<Item> findByCategory(String category) {

        return itemRepo.findByCategory(category);
    }

    public List<Item> findByPriceRange(double from, double to) {

        return itemRepo.findByPriceRange(from, to);
    }

    public List<Item> findByName(String name) {

        return itemRepo.findByName(name);
    }

    public Item findById(long id) {
        return itemRepo.findById(id);
    }

    public void GenerateRandomItems(int count) {

        itemRepo.renderGenerateRandomItems(count);
    }

    // Getter
    public List<Item> getItems() {
        return itemRepo.findAllItems();
    }

}
