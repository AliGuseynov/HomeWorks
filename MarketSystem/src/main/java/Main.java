import az.code.business.SalesService;
import az.code.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) throws Exception {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("start");
        entityManager.getTransaction().begin();

        SalesService salesService = new SalesService();
        System.out.println(salesService.addItem(1));


    }
}
