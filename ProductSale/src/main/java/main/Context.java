package main;

import az.code.repos.ProductRepo;
import az.code.repos.impl.ProductRepoImpl;

public class Context {
    public static ProductRepo instanceProductService(){

        return new ProductRepoImpl();
    }
}
