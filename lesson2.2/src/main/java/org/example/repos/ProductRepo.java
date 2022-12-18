package org.example.repos;

import org.example.models.Product;

import java.util.List;

public interface ProductRepo {

    void createdProduct();
    void updateProduct();

    void deleteProduct();
    void printAllProduct();
    void searchByCategory();

    void searchByName();
    void searchByMinMaxAmount();
}
