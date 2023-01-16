package bookstore;

import bookstore.models.Branch;
import bookstore.models.Store;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.Bookstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


//        createStores(em);


        List<Store> stores = em.createNamedQuery("all_stores").getResultList();

        List<Branch> branches = em.createNamedQuery("all_branches").getResultList();

        updateStores(stores, branches, em);




        em.getTransaction().commit();
        em.close();
    }

    private static void createStores(EntityManager em){
//        Store store = Store.builder().store_name("Libraff 7").build();
//
//        List<Branch.BranchBuilder> tempBranches = List.of(
//                Branch.builder().branch_name("Ganjlik 7"),
//                Branch.builder().branch_name("28 mall 7")
//                );
//
//        List<Branch> branchesBuilded = new ArrayList<>();
//
//        for (Branch.BranchBuilder branch: tempBranches){
//            Branch tempbranch2 = branch.build();
//            branchesBuilded.add(tempbranch2);
//            em.merge(tempbranch2);
//        }
//
//        em.merge(store);
    }

    private static void updateStores(List<Store> stores, List<Branch> branches, EntityManager em){


        System.out.println(stores.size() + " stores");

        for (Store store: stores){
            store.setBranches(branches);
            em.merge(store);
        }

        updateBranches(stores, branches, em);
    }

    private static void updateBranches(List<Store> stores, List<Branch> branches, EntityManager em){
        for (int i = 0; i< branches.size(); i++){
            Branch branch = branches.get(i);
            branch.setStore(stores.get(0));
            System.out.println(branch.getBranch_name());
            em.merge(branch);
            System.out.println(branch.getStore().getStore_name());
        }
    }

}
