package az.code.repos.impl;

import az.code.models.Product;
import az.code.repos.AbstractDao;
import az.code.repos.ProductRepo;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProductRepoImpl extends AbstractDao implements ProductRepo {


    @Override
    public void add(Product product) {
        Product oldProduct = findById(product.getProductId());
        EntityManager em = em();
        em.getTransaction().begin();
        if (oldProduct != null) {
            oldProduct.setProductId(product.getProductId());
            oldProduct.setCategory(product.getCategory());
            oldProduct.setProductCount(oldProduct.getProductCount() + product.getProductCount());
            oldProduct.setProductPrice(product.getProductPrice());
            oldProduct.setProductName(product.getProductName());
            em.merge(oldProduct);
        } else {
            em.merge(product);
        }
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public boolean saleProduct(Long id, double count) {
        EntityManager em = em();
        em.getTransaction().begin();
        Product product = findById(id);
        product.setProductCount(product.getProductCount() - count);
        em.merge(product);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public void remove(Product product) {
//        Product oldProduct = findById(product.getProductId());
//        if (oldProduct != null) {
//            products.remove(product);
//        } else {
//            System.out.println("duzgun product elave edin");
//        }
    }

    @Override
    public List<Product> getAll() {
        EntityManager em = em();
        String jpql = "select p from Product p  ";
        Query query = em.createQuery(jpql, Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(Long code) {
        EntityManager em = em();
        Product product = em.find(Product.class, code);
        em.close();
        return product;
    }

    @Override
    public List<Product> findByName(String name) {
//        List<Product> findProduct = new ArrayList<>();
//        for (Product product : products
//        ) {
//            if (product.getProductName().equals(name)) {
//                findProduct.add(product);
//            }
//        }
        return null;
    }

    @Override
    public List<Product> findByPriceRange(double from, double to) {
//        List<Product> results = new ArrayList<>();
//        for (Product product : products) {
//            if (product.getProductPrice() >= from && product.getProductPrice() <= to) {
//                results.add(product);
//            }
//        }
        return null;
    }

    @Override
    public void removeById(Long code) {
//        Product deleted = null;
//        for (Product product : products) {
//            if (product.getProductId().equals(code)) {
//                deleted = product;
//                break;
//            }
//        }
//        products.remove(deleted);
    }
}
