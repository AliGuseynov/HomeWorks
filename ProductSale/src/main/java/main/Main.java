package main;

import az.code.repos.AbstractDao;
import az.code.models.Category;
import az.code.models.Product;
import az.code.models.Sales;
import az.code.models.SalesItems;
import az.code.repos.ProductRepo;
import az.code.repos.impl.ProductRepoImpl;
import az.code.repos.impl.SalesRepoImpl;
import az.code.service.ProductService;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends AbstractDao {
    public static void main(String[] args) {
        ProductRepoImpl productRepo=new ProductRepoImpl();
//        ProductService productService=new ProductService();
//        productRepo.saleProduct(1l,20);
//        productService.allProducts();
//        SalesRepoImpl salesRepo=new SalesRepoImpl();
//        salesRepo.save(1l,20);
//        productService.addProduct(3l,"Qatiq",2.76,Category.HomeProduct,10);
//productService.allProducts();
//        SalesRepoImpl salesRepo=new SalesRepoImpl();
//        salesRepo.save(1l,12);
//        EntityManager em = em();
//        em.getTransaction().begin();

//       em.merge(product1);
//       em.merge(product);
//        em.getTransaction().commit();
//        em.close();

    }
}
