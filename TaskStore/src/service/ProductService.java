package service;

import models.Product;
import models.ProductCategory;
import repos.ProductRepo;
import repos.factory.ProductFactory;
import repos.impl.ProductRepoMemoryImpl;

public class ProductService {
    ProductRepo productRepo = ProductFactory.createProductRepo("memory");

    public void withdrawProductFromProducts(String productCode){

       productRepo.removeByCode(productCode);
    }

    public void returnProducts(){
        System.out.println(productRepo.findAll());
    }

    public void addNewProduct(Product product){
        productRepo.save(product);
    }

    public void replaceProductInfo(String code, String name, double price, ProductCategory category, int count){
        productRepo.save(new Product(name, price, category, count, code));
    }

    public void searchProductsByCategory(ProductCategory productCategory){
        for(Product e: products){
            if(e.getCategory().equals(productCategory)) System.out.println(e);
        }
    }

    public void searchProductsByPriceRange(double lowerPrice, double higherPrice){
        for(Product product: productRepo.findByPriceRange(lowerPrice, higherPrice)){
            System.out.println(product);
        }
    }

    public void searchProductsByName(String productName){
        System.out.println(productRepo.findByName(productName));
    }
}
