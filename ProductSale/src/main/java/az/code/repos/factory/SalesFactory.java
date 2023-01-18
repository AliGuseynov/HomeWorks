package az.code.repos.factory;

import az.code.repos.SalesRepo;
import az.code.repos.impl.SalesRepoImpl;


public class SalesFactory {
    public static SalesRepo createProductRepo(String type){
        SalesRepo salesRepo = null;
        switch (type){
            case "memory": salesRepo = new SalesRepoImpl();
                break;
            case "database":salesRepo=new SalesRepoImpl();
                break;
        }
        return salesRepo;
    }
}
