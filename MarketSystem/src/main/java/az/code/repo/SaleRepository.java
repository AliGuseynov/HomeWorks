package az.code.repo;

import az.code.Print;
import az.code.business.SalesService;
import az.code.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Scanner;

public class SaleRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    SalesService salesService = new SalesService();
    //    Print print = new Print();
    Scanner s = new Scanner(System.in);


    public void product() throws Exception {
        System.out.println("Enter product code and count");
        String code = s.nextLine();
        int count = s.nextInt();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
        Root<Product> productRoot = criteriaQuery.from(Product.class);


        Predicate codeProduct = builder.equal(productRoot.get("productCode"), code);
        Predicate countProduct = builder.ge(productRoot.get("productCount"), count);
        Predicate soldProduct = builder.and(codeProduct, countProduct);
        criteriaQuery.where(soldProduct);

        Product product = entityManager.createQuery(criteriaQuery).getSingleResult();

        product.setProductCount(product.getProductCount() - count);
        salesService.addItem(product, count);
        System.out.println(product);

//        print.forMenu();

    }


    public void save() {
        entityManager.getTransaction().begin();

        entityManager.merge(salesService.newSales());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
