package service;

import model.Sales;
import model.SalesItems;
import repos.ProductRepo;
import repos.SalesRepo;
import repos.factory.SalesFactory;

import java.time.LocalDate;

public class SalesService {
    SalesRepo salesRepo = SalesFactory.createProductRepo("memory");

    public void deletedSales(Sales sale) {
        salesRepo.remove(sale);
    }

    public void addSale(Sales sale) {
        salesRepo.save(sale);
    }

    public void allSales() {
        for (Sales sale : salesRepo.findAll()
        ) {
            System.out.println(sale);
        }
    }

    public void findSalesByRangeDate(LocalDate localDate1, LocalDate localDate2) {
        for (Sales sale : salesRepo.findByDateRange(localDate1, localDate2)
        ) {
            System.out.println(sale);
        }
    }

    public void findSalesByRangePay(double min, double max) {
        for (Sales sale : salesRepo.findByPayRange(min, max)
        ) {
            System.out.println(sale);
        }
    }

    public void findSalesByDate(LocalDate localDate) {

        for (Sales sale : salesRepo.findByDate(localDate)
        ) {
            System.out.println(sale);
        }


    }

    public void findSalesById(String id) {
        System.out.println(salesRepo.findBySerialNumber(id));
    }

    public void returnSales(String id,String salesItemsId ,double salescount) {
        for (Sales sale : salesRepo.findAll()
        ) {
            if (sale.getSalesId().equals(id)) {
                for (SalesItems salesItems:sale.getSalesItems()
                     ) {
                    if(salesItems.getSalesItemsId().equals(salesItemsId)){
                       if(salesItems.getSalescount()>salescount){
                           salesItems.setSalescount( salesItems.getSalescount()-salescount);
                           salesItems.getProduct().setProductCount(salesItems.getProduct().getProductCount()+salescount);
                       }else{
                           System.out.println("salescount yanlisdir");
                       }
                    }
                }
            }
        }
    }
}
