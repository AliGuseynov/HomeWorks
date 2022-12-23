package org.example.repos.factory;

import org.example.repos.ProductRepo;
import org.example.repos.impl.ProductMemoryImpl;

public class ProductFactory {
    public static ProductRepo createProductRepo(String type){
        ProductRepo productRepo = null;
        switch (type){
            case "memory": productRepo = new ProductMemoryImpl();
                break;
        }
        return productRepo;
    }
}
