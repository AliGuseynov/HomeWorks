package repos.impl;

import model.Product;
import model.Sales;
import repos.ProductRepo;
import repos.SalesRepo;
import repos.factory.ProductFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesRepoMemoryImpl implements SalesRepo {
    List<Sales> sales = new ArrayList<>();

    @Override
    public void save(Sales sale) {
        Sales oldSale = findBySerialNumber(sale.getSalesId());
        if (oldSale != null) {
            oldSale.setSalesItems(sale.getSalesItems());
            oldSale.setSalesPay(oldSale.getSalesPay());
            oldSale.setSalesItems(oldSale.getSalesItems());
            oldSale.setLocalDate(oldSale.getLocalDate());
        } else {
            sales.add(sale);
        }
    }

    @Override
    public void remove(Sales sale) {
        Sales oldSale = findBySerialNumber(sale.getSalesId());
        if (oldSale != null) {
            sales.remove(sale);
        } else {
            System.out.println("bele bit satis olmayibdi");
        }
    }

    @Override
    public List<Sales> findAll() {
        return sales;
    }

    @Override
    public List<Sales> findByDateRange(LocalDate localDate1, LocalDate localDate2) {
        List<Sales> findSale = new ArrayList<>();
        for (Sales sale : sales
        ) {
            if (1 == sale.getLocalDate().compareTo(localDate1) && 1 == localDate2.compareTo(sale.getLocalDate())) {
                findSale.add(sale);
            }
        }
        return findSale;
    }

    @Override
    public List<Sales> findByPayRange(double from, double to) {
        List<Sales> findSale = new ArrayList<>();
        for (Sales sale : sales
        ) {
            if (sale.getSalesPay() > from && sale.getSalesPay() < to) {
                findSale.add(sale);
            }
        }
        return findSale;
    }

    @Override
    public Sales findBySerialNumber(String serialNumber) {
        Sales findSale = null;
        for (Sales sale : sales
        ) {
            if (sale.getSalesId().equals(serialNumber)) {
                findSale = sale;
                break;
            } else {
                System.out.println("bele bir satis yoxdur");
            }
        }
        return findSale;
    }

    @Override
    public List<Sales> findByDate(LocalDate localDate) {
        List<Sales> findSale = new ArrayList<>();

        for (Sales sale : sales
        ) {
            if (sale.getLocalDate().equals(localDate)) {
                findSale.add(sale);
            }

        }
        return findSale;
    }
}
