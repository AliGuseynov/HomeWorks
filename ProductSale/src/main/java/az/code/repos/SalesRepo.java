package az.code.repos;

import az.code.models.Sales;


import java.time.LocalDate;
import java.util.List;

public interface SalesRepo {
    void save(Long id,double count);
    void remove(Sales sale);
    List<Sales> findAll();
    List<Sales> findByDateRange(LocalDate localDate1, LocalDate localDate2);
    List<Sales> findByPayRange(double from, double to);
    Sales findBySerialNumber(Long  serialNumber);
    List<Sales> findByDate(LocalDate localDate);
}

