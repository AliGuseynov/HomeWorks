package az.code.repos;

import az.code.models.SalesItems;

public interface SalesItemsRepo {
    void add(Long id, double count);
    SalesItems findById(Long id);
}
