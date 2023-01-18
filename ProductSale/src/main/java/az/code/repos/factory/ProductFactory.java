package az.code.repos.factory;

import az.code.repos.ProductRepo;
import az.code.repos.impl.ProductRepoImpl;


public class ProductFactory {
    public static ProductRepo createProductRepo(String type){
        ProductRepo productRepo = null;
        switch (type){
            case "memory": productRepo = new ProductRepoImpl();
                break;
            case "database":productRepo=new ProductRepoImpl();
            break;
        }
        return productRepo;
    }
}
