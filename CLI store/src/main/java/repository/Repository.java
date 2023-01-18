package repository;

import models.Product;
import models.Sale;
import models.SaleItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Repository {


    public static List<Product> selectAllItems(boolean print){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.Store");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


//            Product pr = Product.builder().product_name("Test thing").product_price(24.6).product_category("thing").build();

//            em.merge(pr);

        List<Product> products = em.createNamedQuery("all_products").getResultList();

        if (print){
            products.forEach(System.out::println);}


//            em.getTransaction().commit();


        em.close();
        return products;
    }


    public static void createSale(HashMap<String, Integer> items, HashMap<String, Product> products){

        Set<String> keys =  items.keySet();
        Sale sale = null;
        List<SaleItem> saleItems = new ArrayList<>();

        Double sum = 0.0;

        for (String st: keys){
            Product pr = products.get(st);
            saleItems.add(SaleItem.builder().sale(sale).product(products.get(st)).count(items.get(st)).build());
            sum += (pr.getProduct_price() * items.get(st));
        }

        sale = Sale.builder().check_sum(sum).build();


        sale.setItems(saleItems);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.Store");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(sale);
        em.getTransaction().commit();
        em.close();

        System.out.println(sale.getSale_id());

    }
}
