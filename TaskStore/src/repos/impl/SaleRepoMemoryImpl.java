package repos.impl;

import models.Sale;
import repos.SaleRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleRepoMemoryImpl implements SaleRepo {
    List<Sale> sales = new ArrayList<>();

    @Override
    public void save(Sale sale) {
        sales.add(sale);
    }

    @Override
    public void remove(Sale sale) {
        sales.remove(sale);
    }

    @Override
    public List<Sale> findAll() {
        return sales;
    }

    @Override
    public List<Sale> findByDateRange(Date from, Date to) {
        return null;
    }

    @Override
    public List<Sale> findByPriceRange(double from, double to) {
        return null;
    }

    @Override
    public Sale findBySerialNumber(String serialNumber) {
        return null;
    }
}
