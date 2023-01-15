package bookstore;

import bookstore.models.Branches;
import bookstore.models.Stores;
import org.dom4j.Branch;

import javax.persistence.*;
import java.sql.*;
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.Bookstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        Stores store = findStore(1l, em);
        Branches branch = Branches.builder().branch_name("Nizami str.")
                .store(Stores.builder().store_name("Ali & Nino").build()).build();

//        Branches branch = Branches.builder().branch_name("Ganjlik")
//                .store(store).build();

        em.persist(branch);
        em.getTransaction().commit();
        em.close();
    }


    private static Stores findStore(Long storeID, EntityManager em){
        Stores store = em.find(Stores.class, storeID);
        em.detach(store);
        System.out.println(store);
        return store;
    }
}
