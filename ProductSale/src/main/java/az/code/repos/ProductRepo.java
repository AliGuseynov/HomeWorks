package az.code.repos;

import az.code.models.Product;


import java.util.List;

public interface ProductRepo {
    void add(Product product);
    void remove(Product product);
    List<Product> getAll();
    Product findById(Long code);
    List<Product> findByName(String name);
    List<Product> findByPriceRange(double from, double to);
    void removeById(Long code);
    boolean saleProduct(Long id,double count);
}
