package service;

import model.Category;
import model.Product;
import repos.ProductRepo;
import repos.factory.ProductFactory;
import repos.impl.ProductRepoMemoryImpl;

public class ProductService {
    ProductRepo productRepo = ProductFactory.createProductRepo("memory");
    public void deletedProductById(String productCode){

        productRepo.removeById(productCode);
    }
    public void addProduct(Product product){

        productRepo.save(product);
    }
    public void updateProduct(String id, String name, double price, Category category, double count){
        productRepo.save(new Product(name, price, category, count, id));
    }
    public void searchProductsByCategory(Category productCategory){
        for(Product product: ProductRepoMemoryImpl.products){
            if(product.getCategory().equals(productCategory))
                System.out.println(product);
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
    public void allProducts(){
        for (Product product :productRepo.findAll()
             ) {
            System.out.println(product);
        }

    }
}
