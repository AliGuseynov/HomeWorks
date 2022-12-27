package repos.impl;

import models.Product;
import models.Sale;
import repos.ProductRepo;
import repos.SaleRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductRepoMemoryImpl implements ProductRepo {
    List<Product> products = new ArrayList<>();

    @Override
    public void save(Product product) {
        Product oldProduct = findByCode(product.getCode());
        if(oldProduct != null){
            oldProduct.setCategory(product.getCategory());
            oldProduct.setCount(product.getCount());
            oldProduct.setPrice(product.getPrice());
            oldProduct.setName(product.getName());
        }else{
            products.add(product);
        }
    }

    @Override
    public void remove(Product product) {

    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findByCode(String code) {
        return null;
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public List<Product> findByPriceRange(double from, double to) {
        List<Product> results = new ArrayList<>();
        for (Product e: products){
            if(e.getPrice() >= from && e.getPrice() <= to){
                results.add(e);
            }
        }
        return results;
    }

    @Override
    public void removeByCode(String code) {
        Product deleted = null;
        for (Product e: products){
            if(e.getCode().equals(code)){
                deleted = e;
                break;
            }
        }
        products.remove(deleted);
    }


}
