package repos;

import models.Product;

import java.util.List;

public interface ProductRepo {
    void save(Product product);
    void remove(Product product);
    List<Product> findAll();
    Product findByCode(String code);
    Product findByName(String name);
    List<Product> findByPriceRange(double from, double to);
    void removeByCode(String code);

}
