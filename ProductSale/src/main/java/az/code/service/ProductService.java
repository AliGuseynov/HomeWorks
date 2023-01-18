package az.code.service;

import az.code.models.Category;
import az.code.models.Product;
import az.code.models.SalesItems;
import az.code.repos.AbstractDao;
import az.code.repos.ProductRepo;
import az.code.repos.factory.ProductFactory;

import javax.persistence.EntityManager;
import java.util.List;


public class ProductService extends AbstractDao {
    ProductRepo productRepo = ProductFactory.createProductRepo("database");

    public void deletedProductById(Long productCode) {

        productRepo.removeById(productCode);
    }

    public void addProduct(Long id, String name, double productPrice, Category categoryName, double productCount) {
        productRepo.add(new Product(id, name, productPrice, categoryName, productCount));
    }



    public void searchProductsByCategory(Category productCategory) {
//        for (Product product : ProductRepoMemoryImpl.products) {
//            if (product.getCategory().equals(productCategory))
//                System.out.println(product);
//        }
    }

    public void searchProductsByPriceRange(double lowerPrice, double higherPrice) {
        for (Product product : productRepo.findByPriceRange(lowerPrice, higherPrice)) {
            System.out.println(product);
        }
    }

    public void searchProductsByName(String productName) {

        System.out.println(productRepo.findByName(productName));
    }

    public void allProducts() {
        for (Product product : productRepo.getAll()
        ) {
            System.out.println(product);
        }

    }
}
