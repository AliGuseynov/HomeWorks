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
//        System.out.println(productRepo.findById(1l));
//        ProductService productService=new ProductService();
//        productRepo.saleProduct(1l,20);
//        productService.allProducts();
//        SalesRepoImpl salesRepo=new SalesRepoImpl();
//        salesRepo.save(1l,20);
//        productService.addProduct(3l,"Qatiq",2.76,Category.HomeProduct,10);
//productService.allProducts();
//        SalesRepoImpl salesRepo=new SalesRepoImpl();
//        salesRepo.save(2l,12);
//        EntityManager em = em();
//        em.getTransaction().begin();

//       em.merge(product1);
//       em.merge(product);
//        em.getTransaction().commit();
//        em.close();
        EntityManager em = em();
        em.getTransaction().begin();
        List<SalesItems> salesItems = new ArrayList<>();
        double totalPay=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("codunu ve sayini daxil edin");
        Long id=scanner.nextLong();
        Double count=scanner.nextDouble();
        while(true){
            Product product = productRepo.findById(id);
            if (product.getProductCount() > count) {
                SalesItems salesItems1=new SalesItems(id,product,count);
                salesItems.add(salesItems1);
                totalPay+=salesItems1.getSalescount()*product.getProductPrice();
                System.out.println("davam ya bitirmek");
                Scanner sc=new Scanner(System.in);
                String teklif=sc.nextLine();
                if(teklif.equals("bitirmek")){
                    em.merge(salesItems1);
                    Sales sales=new Sales(1l,totalPay,salesItems,LocalDate.now());
                    em.merge(sales);
                    em.getTransaction().commit();
                    em.close();
                    emfclose();
                }else{
                    Scanner scanner1=new Scanner(System.in);
                    System.out.println("codunu ve sayini daxil edin");
                    Long id1=scanner1.nextLong();
                    Double count1=scanner1.nextDouble();
                    for (SalesItems salesitem : salesItems) {
                        productRepo.saleProduct(id1, count1);
                        Product productSale = productRepo.findById(id);
                        if (salesitem.getProduct().getProductId() == id && productSale.getProductCount() > count) {
                            salesitem.setSalescount(salesitem.getSalescount() + count);
                            totalPay+=salesitem.getSalescount()*productSale.getProductPrice();
                            em.merge(salesitem);
                        } else{
                            SalesItems salesItems2=new SalesItems(id,productSale,count);
                            salesItems.add(salesItems2);
                            em.merge(salesItems2);
                            totalPay+=salesItems1.getSalescount()*productSale.getProductPrice();
                        }
                    }
                    Sales sales=new Sales(1l,totalPay,salesItems,LocalDate.now());
                    em.merge(sales);
                    em.getTransaction().commit();
                    em.close();
                    emfclose();
                }
            }else{
                System.out.println("o qeder mehsul yoxdur");
                em.close();
                emfclose();
            }

        }

    }
}
