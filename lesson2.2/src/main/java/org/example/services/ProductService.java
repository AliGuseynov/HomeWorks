package org.example.services;

import org.example.models.Product;
import org.example.models.ProductCategory;
import org.example.repos.ProductRepo;
import org.example.repos.factory.ProductFactory;


public class ProductService {
    ProductRepo productRepo = ProductFactory.createProductRepo("memory");
    public void returnProducts(){
        productRepo.printAllProduct();
    }

    public void addNewProduct(){
        productRepo.createdProduct();
    }

    public void updateProductInfo(){
        productRepo.updateProduct();
    }
    public void deleteProduct(){
        productRepo.deleteProduct();
    }
    public void searchProductsByCategory(){
        productRepo.searchByCategory();
    }

    public void searchProductsByPriceRange(){
        productRepo.searchByMinMaxAmount();
    }

    public void searchProductsByName(){
        productRepo.searchByName();
    }

}
