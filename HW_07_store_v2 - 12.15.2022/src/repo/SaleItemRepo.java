package repo;

import model.SaleItem;

import java.util.List;

public interface SaleItemRepo {

    List<SaleItem> addSaleItem(String numbers);
    int isItemExistInStock(long id, int count);
}
