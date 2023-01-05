package az.code.shopManagement.service;

import az.code.shopManagement.model.Category;
import az.code.shopManagement.model.Product;
import az.code.shopManagement.model.Purchase;
import az.code.shopManagement.model.PurchasedGood;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Marketable implements IMarketable{

    static List<Product> products = new ArrayList<>();
    static List<Purchase> purchases = new ArrayList<>();
    static List<PurchasedGood> purchasedGoods = new ArrayList<>();


    public static void generateProduct(){
        for(int i = 0 ; i < 20 ; i++)
        {
        Random rd = new Random();
        products.add(new Product(i, "product"+i ,(rd.nextDouble()*300)+1,
                (rd.nextInt()*1000)+1, (rd.nextInt()*1000)+1,
                Category.values()[rd.nextInt(Category.values().length)] ));
        }
    }

    public static void createNewProduct(){
        Scanner scan = new Scanner(System.in);
        System.out.println("How much products you want to add? ");
        int NUM = scan.nextInt();
        for(int i = 0 ; i < NUM ; i++) {
            System.out.print("\nId: ");
            int ID = scan.nextInt();
            System.out.print("Product Name: ");
            String PRODUCT_NAME = scan.next();
            System.out.print("Price: ");
            double PRICE = scan.nextDouble();
            System.out.print("In stock count: ");
            int IN_STOCK_COUNT = scan.nextInt();
            System.out.print("Out of stock count: ");
            int OUT_OF_STOCK_COUNT = scan.nextInt();
            System.out.print("Category: ");
            Category CATEGORY = Category.valueOf(scan.next().toUpperCase());
            products.add(new Product(ID, PRODUCT_NAME, PRICE, IN_STOCK_COUNT, OUT_OF_STOCK_COUNT, CATEGORY));
        }
    }

    public static void updateProduct(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter id of product you want to update: ");
        int ID = scan.nextInt();
        System.out.println("Enter details to update product: \n" +
                "Product Name: ");
        String PRODUCT_NAME = scan.next();
        System.out.print("Price: ");
        double PRICE = scan.nextDouble();
        System.out.print("In stock count: ");
        int IN_STOCK_COUNT = scan.nextInt();
        System.out.print("Out of stock count: ");
        int OUT_OF_STOCK_COUNT = scan.nextInt();
        System.out.print("Category(cloth, shoe, bag, accessory): ");
        Category CATEGORY = Category.valueOf(scan.next().toUpperCase());
        for(Product c: products)
        {
            if(c.getId() == ID)
            {
                c = new Product(ID, PRODUCT_NAME, PRICE, IN_STOCK_COUNT, OUT_OF_STOCK_COUNT, CATEGORY);
            }
        }
    }

    public static void deleteProduct(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter id of product you want to delete: ");
        int ID = scan.nextInt();
        Product deleted = null;
        for(Product p: products){
            if(p.getId() == ID) {
                deleted = p;
                break;
            }
        }
        products.remove(deleted);
    }

    public static List<Product> getAllProducts(){
        return products;
    }
    public static void searchByCategory(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter category: ");
        Category CATEGORY = Category.valueOf(scan.next().toUpperCase());
        for(Product p: products){
            if(p.getCategory() == CATEGORY) {
                System.out.println(p);
            }
        }
    }

    public static void searchByPrice(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter max price: ");
        double MAX = scan.nextDouble();
        System.out.println("Enter min price: ");
        double MIN = scan.nextDouble();
        for(Product p: products){
            if(p.getPrice() > MIN && p.getPrice() < MAX){
                System.out.println(p);
            }
        }
    }

    public static void searchByName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter text to search: ");
        String text = scan.nextLine();
        for(Product p: products){
            if(p.getProductName().contains(text)){
                System.out.println(p);
            }
        }
    }

    public static void addPurchasedGood(){
        Scanner scan = new Scanner(System.in);
        System.out.println("How many types of products in a purchase: ");
        int a = scan.nextInt();
        System.out.print("Enter id of purchase: ");
        int PURCHASE_ID = scan.nextInt();
        for(int i = 0 ; i < a ; i++) {
            System.out.print("Product Id (Purchased): ");
            int PRODUCT_ID = scan.nextInt();
            System.out.print("Product Count (Purchased): ");
            int NUM = scan.nextInt();
            purchasedGoods.add(new PurchasedGood(PURCHASE_ID,PRODUCT_ID , NUM));
        }
    }
    public static void addPurchase(){
        Scanner scan = new Scanner(System.in);
        addPurchasedGood();
        int ID = 0;
        System.out.print("Enter purchase date (yyyy-mm-dd): ");
        String PURCHASE_DATE = scan.next();
        double PRICE = 0;
        for(PurchasedGood p: purchasedGoods){
            for(Product product: products) {
                if(p.getProductId() == product.getId()){
                    PRICE += product.getPrice();
                    ID = p.getProductId();
                }
            }
        }
        purchases.add(new Purchase(ID, PRICE, LocalDate.parse(PURCHASE_DATE), purchasedGoods));
    }

    public static void returnProduct(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter purchase id: ");
        int PURCHASE_ID = scan.nextInt();
        System.out.print("Enter product id: ");
        int PRODUCT_ID = scan.nextInt();
        System.out.print("Enter count pf product: ");
        int COUNT = scan.nextInt();
            for(PurchasedGood g:purchasedGoods)
            {
                if(g.getPurchaseId() == PURCHASE_ID && g.getProductId() == PRODUCT_ID){
                    g.setPurchasedCount(g.getPurchasedCount() - COUNT);
                    System.out.println("Product returned. ");
                }
            }
    }
    public static void deletePurchase(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Puchase Id :");
        int ID = scan.nextInt();
        for(Purchase p: purchases) {
            if(p.getId() == ID)
                purchases.remove(p);
            for(PurchasedGood g: purchasedGoods){
                if(g.getPurchaseId()== ID)
                    purchasedGoods.remove(g);
            }
        }
    }
    public static void getAllPurchases(){
        for(Purchase p: purchases)
        {
            System.out.println("Purchase Id:" + p.getId() + " | " +
                                "Purchase Total Cost: " + p.getTotalCost() + " | " +
                                "Purchase Date: " + p.getPurchaseDate() + "\n");
            for(PurchasedGood g: purchasedGoods)
            {
                if(p.getId() == g.getPurchaseId())
                {
                    System.out.println("Product Id: " + g.getProductId() + " | " +
                                        "Product Count: " + g.getPurchasedCount());
                }
            }
        }
    }
    public static void searchPurchaseByPeriod(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter beginning date of purchase period (yyyy-mm-dd): ");
        String BEGINNING_DATE = scan.next();
        System.out.print("Enter end date of purchase period (yyyy-mm-dd): ");
        String END_DATE = scan.next();

        for(Purchase p: purchases)
        {
            if(p.getPurchaseDate().isBefore(LocalDate.parse(END_DATE)) &&
                    p.getPurchaseDate().isAfter(LocalDate.parse(BEGINNING_DATE))) {
                System.out.println("Purchase Id:" + p.getId() + " | " +
                        "Purchase Total Cost: " + p.getTotalCost() + " | " +
                        "Purchase Date: " + p.getPurchaseDate() + "\n");
            }
        }
    }
    public static void searchPurchaseByPriceRange(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter max price: ");
        int MAX = scan.nextInt();
        System.out.print("Enter min price: ");
        int MIN = scan.nextInt();
        for(Purchase p: purchases)
        {
            if(p.getTotalCost() > MIN && p.getTotalCost() < MAX) {
                System.out.println("Purchase Id:" + p.getId() + " | " +
                        "Purchase Total Cost: " + p.getTotalCost() + " | " +
                        "Purchase Date: " + p.getPurchaseDate() + "\n");
            }
        }
    }
    public static void searchPurchaseByDate(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter date of purchase (yyyy-mm-dd): ");
        String DATE = scan.next();
        for(Purchase p: purchases)
        {
            if(p.getPurchaseDate().equals(LocalDate.parse(DATE))) {
                System.out.println("Purchase Id:" + p.getId() + " | " +
                        "Purchase Total Cost: " + p.getTotalCost() + " | " +
                        "Purchase Date: " + p.getPurchaseDate() + "\n");
            }
        }
    }
    public static void getPurchaseById(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter purchase id: ");
        int ID = scan.nextInt();
        for(Purchase p: purchases)
        {
            if(p.getId() == ID) {
                System.out.println("Purchase Id:" + p.getId() + " | " +
                        "Purchase Total Cost: " + p.getTotalCost() + " | " +
                        "Purchase Date: " + p.getPurchaseDate() + "\n");
            }
            for(PurchasedGood g: purchasedGoods)
            {
                if(p.getId() == g.getPurchaseId())
                {
                    System.out.println("Product Id: " + g.getProductId() + " | " +
                            "Product Count: " + g.getPurchasedCount());
                }
            }
        }
    }


}
