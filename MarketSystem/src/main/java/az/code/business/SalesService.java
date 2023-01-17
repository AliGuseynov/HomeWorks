package az.code.business;

import az.code.entities.Item;
import az.code.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class SalesService {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    List<Product> productList1 = entityManager.createQuery(
            "select p from Product p").getResultList();

    //    private List<Product> productList;
    private List<String> items=new ArrayList<>();


    public List<String> addItem(int id) throws Exception {
        for (int i = 0; i < productList1.size(); i++) {
            if (isExist(id)) {
                items.add(productList1.get(i).getProductName());

            } else throw new Exception("Mehsul Tapilmadi");
        }

        return items;
    }


    public boolean isExist(int id) {
        for (Product product : productList1) {
            if (product.getProductId() == id) {
                return true;
            }
        }
        return false;
    }

}
