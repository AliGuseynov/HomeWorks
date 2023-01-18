import az.code.models.CATEGORY;
import az.code.models.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args)

    {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("az.code.models");
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        Product p=Product.builder().name("milk").price(5).category(CATEGORY.FOOD).build();
        em.merge(p);
        em.getTransaction().commit();
        em.close();

    }
}