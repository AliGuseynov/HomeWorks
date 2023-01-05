package az.code.shopManagement.service;

import az.code.shopManagement.model.Product;

import java.util.List;

public interface IMarketable {

    //Product
    public static void createNewProduct(){}
    public static void updateProduct(){}
    public static void deleteProduct(){}
    public static List<Product> getAllProducts(){
        return null;
    }
    public static void searchByCategory(){}
    public static void searchByPrice(){}
    public static void searchByName(){}

    //Purchase
    public static void addPurchase(){}
    public static void returnProduct(){}
    public static void searchPurchaseByPeriod(){}
    public static void searchPurchaseByDate(){}
    public static void searchPurchaseByPriceRange(){}
    public static void getPurchaseById(){}
}
