import az.code.models.Category;
import az.code.models.Product;
import az.code.services.Marketable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Marketable m = new Marketable();
        m.firstOption();

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.models");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
////        Product p = Product.builder().price(45).inStockCount(16).code(444l).category(Category.CLOTH).build();
//        Product p = Product.builder().price(70).inStockCount(10).code(555l).category(Category.SHOES).build();
//        em.persist(p);
//
//        em.getTransaction().commit();
//        em.close();
    }
}
