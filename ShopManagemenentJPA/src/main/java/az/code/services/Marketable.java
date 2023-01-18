package az.code.services;

import az.code.models.Item;
import az.code.models.Product;
import az.code.models.Sale;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Marketable {
    Scanner scan = new Scanner(System.in);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.models");
    EntityManager em = emf.createEntityManager();

    List<Item> items = new ArrayList<>();

    public void firstOption(){
        System.out.println("\n\n1. Create new sale.");
        System.out.println("2. Exit");

        int a = scan.nextInt();
        switch(a){
            case 1:
                checkDetails();
                break;
            case 2:
                newSale();
                saveTransaction();
                break;
        }
    }

    public void checkDetails(){
        System.out.println("\n\n++++++New Sale:++++++");
        System.out.println("Code:");
        int CODE = scan.nextInt();
        System.out.println("Count:");
        int COUNT = scan.nextInt();


        try{
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Product> cq = builder.createQuery(Product.class);
            Root<Product> productRoot = cq.from(Product.class);
            Predicate codeProduct =
                    builder.equal(productRoot.get("code"), CODE);
            Predicate countProduct =
                    builder.ge(productRoot.get("inStockCount"), COUNT);
            Predicate soldProduct =
                    builder.and(codeProduct, countProduct);

            cq.where(soldProduct);
            Product product = em.createQuery(cq).getSingleResult();
            product.setInStockCount(product.getInStockCount()-COUNT);

            saveSoldProducts(product,COUNT);

            System.out.println(product);
        }catch(Exception e){
            System.out.println("++++++  PRODUCT UNAVAILABLE ++++++");
        }
        firstOption();
    }



    public void saveSoldProducts(Product p, int COUNT) {
        Item soldItem = new Item();
        soldItem = soldItem.builder().itemCount(COUNT).product(p).build();
        addToItemList(soldItem);

    }
    public List<Item> addToItemList(Item i){
        items.add(i);
        System.out.println(items);
        return items;
    }

    public Sale newSale(){
        double amount = 0;
        for(Item item : items){
            amount += item.getItemCount()*item.getProduct().getPrice();
        }
        Sale currentSale = new Sale();
        currentSale = currentSale.builder().amount(amount).items(items).build();
        System.out.println(currentSale);

        return currentSale;
    }
    public void saveTransaction(){
        em.getTransaction().begin();

        em.merge(newSale());
//        for(Item item : items) {
//            em.merge(item);
//        }
        em.getTransaction().commit();
        em.close();
    }

}
