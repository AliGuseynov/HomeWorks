package repos;

import model.Product;

import java.util.List;

public interface ProductRepo {
    void save(Product product);
    void remove(Product product);
    List<Product> findAll();
    Product findById(String code);
    List<Product> findByName(String name);
    List<Product> findByPriceRange(double from, double to);
    void removeById(String code);
}
