package az.code.repos.impl;

import az.code.models.Product;
import az.code.models.Sales;
import az.code.models.SalesItems;
import az.code.repos.AbstractDao;
import az.code.repos.SalesRepo;
import az.code.service.ProductService;


import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SalesRepoImpl extends AbstractDao implements SalesRepo {
    ProductRepoImpl productRepo = new ProductRepoImpl();


    @Override
    public void save(Long id, double count) {
        List<SalesItems> salesItems = new ArrayList<>();
        double totalPay=0;
        EntityManager em = em();
        em.getTransaction().begin();
        Product product = productRepo.findById(id);
        if (product.getProductCount() > count) {
            SalesItems salesItems1=new SalesItems(id,product,count);
            salesItems.add(salesItems1);
            em.merge(salesItems1);
            totalPay+=salesItems1.getSalescount()*product.getProductPrice();
            for (SalesItems salesitem : salesItems) {
                productRepo.saleProduct(id, count);
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
        }else{
            System.out.println("o qeder mehsul yoxdur");
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Sales sale) {
//        Sales oldSale = findBySerialNumber(sale.getSalesId());
//        if (oldSale != null) {
//            sales.remove(sale);
//        } else {
//            System.out.println("bele bit satis olmayibdi");
//        }
    }

    @Override
    public List<Sales> findAll() {
        return null;
    }

    @Override
    public List<Sales> findByDateRange(LocalDate localDate1, LocalDate localDate2) {
//        List<Sales> findSale = new ArrayList<>();
//        for (Sales sale : sales
//        ) {
//            if (1 == sale.getLocalDate().compareTo(localDate1) && 1 == localDate2.compareTo(sale.getLocalDate())) {
//                findSale.add(sale);
//            }
//        }
        return null;
    }

    @Override
    public List<Sales> findByPayRange(double from, double to) {
//        List<Sales> findSale = new ArrayList<>();
//        for (Sales sale : sales
//        ) {
//            if (sale.getSalesPay() > from && sale.getSalesPay() < to) {
//                findSale.add(sale);
//            }
//        }
        return null;
    }

    @Override
    public Sales findBySerialNumber(Long serialNumber) {
//        Sales findSale = null;
//        for (Sales sale : sales
//        ) {
//            if (sale.getSalesId().equals(serialNumber)) {
//                findSale = sale;
//                break;
//            } else {
//                System.out.println("bele bir satis yoxdur");
//            }
//        }
        return null;
    }

    @Override
    public List<Sales> findByDate(LocalDate localDate) {
//        List<Sales> findSale = new ArrayList<>();
//
//        for (Sales sale : sales
//        ) {
//            if (sale.getLocalDate().equals(localDate)) {
//                findSale.add(sale);
//            }
//
//        }
        return null;
    }
}
