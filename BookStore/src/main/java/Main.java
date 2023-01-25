import az.code.models.Branch;
import az.code.models.Store;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-book-store");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        List<Store> list=new ArrayList<>();
        Branch branch =new Branch(1l,"Niko",list);
        Store store=new Store(1l,"Nihad","NizamiStreet",branch);
        list.add(store);
        em.persist(branch);
        em.persist(store);
        em.getTransaction().commit();
        emf.close();
    }
}
