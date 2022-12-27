package repos.factory;

import repos.ProductRepo;
import repos.impl.ProductRepoMemoryImpl;

public class ProductFactory {
    public static ProductRepo createProductRepo(String type){
        ProductRepo productRepo = null;
        switch (type){
            case "memory": productRepo = new ProductRepoMemoryImpl();
            break;
        }
        return productRepo;
    }
}
