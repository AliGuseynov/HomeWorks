package az.code.business;

import az.code.entities.Item;
import az.code.entities.Product;
import az.code.entities.Sales;
import java.util.ArrayList;
import java.util.List;

public class SalesService {

//    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
//    EntityManager entityManager = entityManagerFactory.createEntityManager();

    List<Item> items = new ArrayList<>();

    public List<Item> addItem(Product product, int count) {
        Item item = new Item();

        item = item.builder().count(count).product(product).build();

        boolean temp = true;
        for (Item item1 : items) {
            if (item1.getProduct().getProductCode() == item.getProduct().getProductCode()) {
                item1.setCount(item1.getCount() + item.getCount());
                temp = false;
            }
        }
        if (temp)
            items.add(item);
        System.out.println(items);
        return items;

    }


    public Sales newSales() {
        double sumAmount = 0;
        for (Item item : items) {
            sumAmount += item.getCount() * item.getProduct().getProductPrice();
        }
        Sales currentSale = new Sales();
        currentSale = currentSale.builder().saleAmount(sumAmount).itemList(items).build();
        System.out.println(currentSale);

        return currentSale;
    }

}
