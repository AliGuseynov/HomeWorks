package repos.factory;

import repos.ProductRepo;
import repos.SalesRepo;
import repos.impl.ProductRepoMemoryImpl;
import repos.impl.SalesRepoMemoryImpl;

public class SalesFactory {
    public static SalesRepo createProductRepo(String type){
        SalesRepo salesRepo = null;
        switch (type){
            case "memory": salesRepo = new SalesRepoMemoryImpl();
                break;
        }
        return salesRepo;
    }
}
