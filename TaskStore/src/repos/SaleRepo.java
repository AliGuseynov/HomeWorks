package repos;

import models.Sale;

import java.util.Date;
import java.util.List;

public interface SaleRepo {
    void save(Sale sale);
    void remove(Sale sale);
    List<Sale> findAll();
    List<Sale> findByDateRange(Date from, Date to);
    List<Sale> findByPriceRange(double from, double to);
    Sale findBySerialNumber(String  serialNumber);


}
