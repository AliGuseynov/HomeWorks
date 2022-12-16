package repos;

import model.Sales;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface SalesRepo {
    void save(Sales sale);
    void remove(Sales sale);
    List<Sales> findAll();
    List<Sales> findByDateRange(LocalDate localDate1, LocalDate localDate2);
    List<Sales> findByPayRange(double from, double to);
    Sales findBySerialNumber(String  serialNumber);
    List<Sales> findByDate(LocalDate localDate);
}

