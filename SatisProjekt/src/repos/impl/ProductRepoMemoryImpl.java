package repos.impl;

import model.Product;
import repos.ProductRepo;

import java.util.ArrayList;
import java.util.List;

public class ProductRepoMemoryImpl implements ProductRepo {
   public static List<Product> products = new ArrayList<>();

    @Override
    public void save(Product product) {
        Product oldProduct = findById(product.getProductId());
        if (oldProduct != null) {
            oldProduct.setCategory(product.getCategory());
            oldProduct.setProductCount(product.getProductCount());
            oldProduct.setProductPrice(product.getProductPrice());
            oldProduct.setProductName(product.getProductName());
        } else {
            products.add(product);
        }

    }

    @Override
    public void remove(Product product) {
        Product oldProduct = findById(product.getProductId());
        if (oldProduct != null) {
            products.remove(product);
        } else {
            System.out.println("duzgun product elave edin");
        }
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(String code) {
        Product findProduct = null;
        for (Product product : products
        ) {
            if (product.getProductId().equals(code)) {
                findProduct = product;
            }
        }
        return findProduct;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> findProduct = new ArrayList<>();
        for (Product product : products
        ) {
            if (product.getProductName().equals(name)) {
                findProduct.add(product);
            }
        }
        return findProduct;
    }

    @Override
    public List<Product> findByPriceRange(double from, double to) {
        List<Product> results = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductPrice() >= from && product.getProductPrice() <= to) {
                results.add(product);
            }
        }
        return results;
    }

    @Override
    public void removeById(String code) {
        Product deleted = null;
        for (Product product : products) {
            if (product.getProductId().equals(code)) {
                deleted = product;
                break;
            }
        }
        products.remove(deleted);
    }
}
